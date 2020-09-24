// Semicolon continuity is based on Java requirements.
const Discord = require('discord.js');
const { inspect } = require('util')
const client = new Discord.Client({disableMentions: "everyone"});
const commandList = require('./commands.json');
const config = require('./config.json');
const prefix = config.prefix; // redundant but i am so used to this so i need this
client.on('ready', () => {
    console.log("Online and ready to go. Prefix is set to " + prefix);
    client.user.setActivity("sup lmao");
    //client.users.resolve(config.developerAccount).send("Rebooted. Prefix is currently set to: " + prefix);
})
process.on('unhandledRejection', error => {
    console.log(error.stack);
    client.users.resolve(config.developerAccount).send(error.stack).catch(e => {
        client.users.resolve(config.developerAccount).send("An error occurred, however I could not send it.");
        console.log("Could not send to the designated developer account for some reason. (Message was likely too long!)");
    })
})
client.on('message', message => {
    if (!message.content.startsWith(prefix)) return;
    if (message.author.bot) return;
    if (message.channel.type == "dm") {
        message.channel.send("can you do this stuff in a server please");
        return;
    }
    var args = message.content.substring(prefix.length).split(" ");
    var command = commandList[args[0].toLowerCase()];
    var permissionSet = [0,0];
    for (let i = 0; i < config.overrideUsers.length; i++) if (message.author.id == config.overrideUsers[i]) permissionSet = [1,2];
    for (let i = 0; i < config.staffRoles.length; i++) if (message.member.roles.cache.has(message.member.guild.roles.cache.findKey(role => role.name === config.staffRoles[i]))) permissionSet = [0,1];
    if (message.member.guild.ownerID === message.author.id) permissionSet = [0,2];
    // bot time
    if (args[0] == "check") {
        message.reply("Checking if you have a role called " + args[1]);
        let checkStat = message.member.roles.cache.has(message.member.guild.roles.cache.findKey(role => role.name === args[1]));
        message.reply("Got: " + checkStat);
        console.log(checkStat);
    }
    if (args[0] == "eval") {
        if (permissionSet[1] < 1) {
            message.reply("You do not have permission to run this. This is GLOBAL command asking for level 1. You are GLOBAL level 0.");
            return;
        }
        let toEval = args.join(" ").slice(args[0].length);
        try {
            var evaluated = inspect(eval(toEval, { depth: 0 }));
        }
        catch(e) {
            message.reply(`something fucked up while evaluating: ${e.message}`);
        }
        try {
            if (!toEval) {
                message.reply("i can't evaluate air dumbass");
            } else {
                message.reply("ok heres what happened");
                message.channel.send(`\`\`\`JavaScript\n${evaluated}\n\`\`\``)
            }
        } catch(e) {
            console.log("Could not evaluate: " + e.message);
        }
    }
})































client.login("redacted");