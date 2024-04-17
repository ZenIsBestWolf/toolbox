const djs = require('discord.js')
const client = new djs.Client({
    partials: ['MESSAGE']
})
const prefix = "!" // old habits die hard baby

let githubtoken = ""

// OB Stuff
const request = require('request');
const path = require('path');

client.on('ready', () => {
    console.log("What the fuck is popping?");
});

client.on('message', async message => {
    if (message.partial) await message.fetch();
    let args = message.content.substring(prefix.length).split(" ");
    let command = args[0].toLowerCase()
    if (command === "loadinfo") {
        // validate target channel ID
  let target = args[1].match(/(?<=<#)\d{17,19}(?=>)|^\d{17,19}$/);

  // validate url
  let file = (args[2] != null) ? args[2].match(/\b((?:[a-z][\w-]+:(?:\/{1,3}|[a-z0-9%])|www\d{0,3}[.]|[a-z0-9.\-]+[.][a-z]{2,4}\/)(?:[^\s()<>]+|\(([^\s()<>]+|(\([^\s()<>]+\)))*\))+(?:\(([^\s()<>]+|(\([^\s()<>]+\)))*\)|[^\s`!()\[\]{};:'".,<>?«»“”‘’]))/gi) : null;

    if(file != null) {
    try {
      file = new URL(file[0]);
    }
    catch(err) {
      // damn bro that sucks
    }
  }

  if (target == null) {
    //return OBUtil.err('You must specify a valid channel.', { m });
    return console.log("WHERE IS THE GOD DAMN CHANNEL")
  }

  target = target[0];

  const channel = client.channels.cache.get(target);

  request(file.href, { headers: { 'Authorization': `token ${githubtoken}` } }, (err, res, body) => {
    if (err) return console.log(err);
    if (res.statusCode !== 200) return console.log("Non 200 status code, fuck. " + res.statusCode);

    body.replace(/<!--(?!OB-)(?:.|\n|\r)*?-->/g, ''); // remove non-function comments

    // isolate img tags
    // (?<=<img\s).+(?=\/?>)

    // isolate functional comments
    // <!--OB-(?:.|\n|\r)*?-->

    const data = [];
    const rawSections = body.split(/(?=<div)/);

    let i = 0;
    (function processSection() {
      const section = rawSections[i];

      const nextSection = () => {
        if(i+1 >= rawSections.length) {
          //Memory._test = data;
          postAll();
        } else {
          i++;
          processSection();
        }
      };

      if (!section.startsWith('<div')) {
        nextSection();
        return;
      }

      const clean = (str) => {
        // replace text, then remove ALL HTML comments
        return str.replace(/(?<=<!--OB-select-->)[\s\S]*?(?=<!--OB-replace([\s\S]+?)-->)/gi, '$1').replace(/<!--(?:.|\n|\r)*?-->/g, '');
      };

      const sectionData = {
        type: 0,
        title: null,
        headerImage: null
      };

      const sectionHeader = section.substring(0, section.indexOf('</div>')); 
      const sectionImageTags = sectionHeader.match(/(?<=<img\s).+(?=\/?>)/);
      const rawEmbeds = (section.includes('###')) ? section.split(/^(?=#{3}(?!#))/gm).slice(1): [];

      if (sectionImageTags != null) {
        const title = sectionImageTags[0].match(/(?<=alt=")[^"]+(?=")/);
        const imageURL = sectionImageTags[0].match(/(?<=src=")[^"]+(?=")/);

        if (title != null) sectionData.title = title[0];

        if (imageURL != null) sectionData.headerImage = imageURL[0];
      }

      data.push(sectionData);

      console.log(rawEmbeds);

      for(const rawEmbed of rawEmbeds) {
        const embed = new djs.MessageEmbed();
        const ce = clean(rawEmbed);

        const title = ce.match(/(?<=^#{3}).*$/m);
        const description = ce.match(/(?<=[\n\r])[\s\S]*?(?=$|[\n\r]#)/);
        const color = rawEmbed.match(/(?<=<!--OB-color\s)[\s\S]*?(?=-->)/);

        if (title != null && title[0].trim().length !== 0) {
          embed.setTitle(title[0].trim());
        }

        if (color != null) {
          switch(color[0].toLowerCase().trim()) {
            case 'red':
              embed.setColor("#dd2e44");
              break;
            case 'green':
              embed.setColor("#43b581");
              break;
            default:
              embed.setColor("#e29f00");
          }
        } else {
          embed.setColor("#e29f00");
        }

        if (description != null && description[0].trim().length !== 0) {
          embed.setDescription(description[0].trim());
        }

        if(rawEmbed.match(/^(?=#{4}(?!#))/gm) != null) {
          const rawFields = rawEmbed.split(/^(?=#{4}(?!#))/gm).slice(1);

          for(const rawField of rawFields) {
            const name = clean(rawField).match(/(?<=^#{4}).*$/m);

            let fieldName;
            let fieldContent = clean(rawField).split('\n').slice(1).join('\n').trim();

            if (fieldContent.length === 0) {
              fieldContent = '_ _'; // "blank" text prevents discord api error
            }

            if (name != null) {
              if(name[0].trim().length !== 0) {
                fieldName = name[0].trim();
              } else {
                fieldName = '_ _'; // "blank" text prevents discord api error
              }
            }

            embed.addField(fieldName, fieldContent, rawField.includes('<!--OB-inline-->'));
          }
        }

        data.push({
          type: 1,
          embed
        });
      }

      nextSection();
    })();

    function postAll() {
      channel.messages.fetch({ limit: 100, force: true }).then(ms => {

        const messages = ms.array().reverse();

        console.log(messages);

        let i = 0;

        function next() {
          console.log('START');
          if(data[i] != null) {
            console.log('new data exists');
            const content = (data[i].type === 0) ? (data[i].headerImage) ? data[i].headerImage : (data[i].title) ? data[i].title : `Untitled Section (idx:${i})` : '_ _';

            if(messages[i] != null) {
              // edit
              console.log('editing message slot');
              data[i].msg = messages[i];

              if(data[i].type === 0) {
                console.log('header');
                if(messages[i].content !== content || messages[i].embeds.length > 0) {
                  updateContent(content);
                } else {
                  i++;
                  next();
                }
              } else if (messages[i].embeds.length > 0) {
                // check embed contents
                console.log('embed already exists');
                if(JSON.stringify(messages[i].embeds[0]) != JSON.stringify(data[i].embed)) {
                  updateEmbed();
                } else {
                  i++;
                  next();
                }
              } else {
                updateEmbed();
              }
            } else {
              // post new
              if(data[i].type === 0) {
                channel.send(content).then((msg) => {
                  data[i].msg = msg;
                  i++;
                  next(); 
                }).catch(err => {
                  console.error(err);
                });
              } else {
                channel.send({ embed: data[i].embed }).then((msg) => {
                  data[i].msg = msg;
                  i++;
                  next(); 
                }).catch(err => {
                  console.error(err);
                });
              }
            }
          } else if (messages[i] != null && !messages[i].deleted) {
            // delete unused message slot
            console.log('new data does not exist');
            console.log('message slot exists, deleting');
            messages[i].delete().then(() => {
              i++;
              next(); 
            }).catch(err => {
              console.error(err);
            });
          } else {
            finish();
          }
        }

        function updateEmbed() {
          console.log('updating embed');
          messages[i].edit('_ _', { embed: data[i].embed }).then(() => {
            i++;
            next();
          }).catch(err => {
            console.error(err);
          });
        }

        function updateContent(content) {
          console.log('updating content');
          messages[i].edit(content, { embed: null }).then(() => {
            i++;
            next();
          }).catch(err => {
            console.error(err);
          });
        }

        function finish() {
          const queue = [];

          let i = -1;
          let qtarget = -1;
          let qdesc = [];

          function compileDesc() {
            if (qtarget > -1 && qdesc.length > 0) {
              queue[qtarget].setDescription(qdesc.join('\n'));

              qdesc = [];
            }
          }

          for(const entry of data) {
            if (entry.type === 0) {
              queue.push(new djs.MessageEmbed()
                .setTitle((entry.title) ? entry.title : `Untitled Section (idx:${i})`)
                .setColor("#e29f00")
              );

              compileDesc();

              /* qdesc.push(
                `**[Jump to section](${entry.msg.url})**`,
                ``
              ); */

              qtarget++;
            } else {
              qdesc.push(`[${(entry.embed.title) ? entry.embed.title : `Untitled`}](${entry.msg.url})`);
            }
          }

          compileDesc();

          (function nextTable() {
            if (i === -1) {
              channel.send('https://raw.githubusercontent.com/Team-OptiFine/Discord-Information/main/BannerImages/tablesupport.png')
                .then(() => {
                  i++;
                  nextTable();
                });
              return;
            }

            if(i >= queue.length) {
              return message.channel.send('done');
            }

            channel.send({ embed: queue[i] }).then(() => {
              i++;
              nextTable();
            }).catch(err => {
              console.error(err);
            });
          })();
        }

        next();
      }).catch(err => {
        console.error(err);
      });
    }
  });
}
});






client.login("")
