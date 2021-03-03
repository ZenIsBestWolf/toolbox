const Discord = require('discord.js');
const client = new Discord.Client({
	disableMentions: "everyone",
	partials: ['MESSAGE']
});
const prefix = "!";
const commands = require('./commands.json');
const random = require('./random.json')

client.on('ready', () => {
	console.log("Ready");
	client.user.setPresence({
		activity: {
			name: "the call of the universe.",
			type: "LISTENING"
		},
		status: "online"
	});
});

client.on('message', async message => {
    if (message.partial) await message.fetch(); // Deal with partials
    if (message.author.bot) return;
    let args = message.content.substring(prefix.length).split(" ");
    let command = commands[args[0].toLowerCase()]; // For some reason, having a variable makes it so the following line works properly.
    if (command === undefined) return;
    
    switch (args[0].toLowerCase()) {
		case "help":
			let tbsHelp = "Here are the list of commands:\n\n";
			for (let i = 0; i < Object.keys(commands).length; i++) { // This looks scary and if anyone has tips for making it less so please tell me.
				let localcmd = commands[Object.keys(commands)[i]]; // makes things less messy
				if (localcmd["info"] == "alias") continue;
				tbsHelp += "**" + prefix + Object.keys(commands)[i];
				let tempvar = localcmd["args"];
				if (!(tempvar === undefined)) {
					tbsHelp += " [" + tempvar + "]";
                };
                tbsHelp += "**: " + localcmd["info"] + "\n"
			};
			message.channel.send(tbsHelp);
			break
        case "assimiliate":
            message.channel.send("Another follower.");
            break;
        case "commune": 
            message.channel.send(random["commune"][Math.floor(Math.random() * random["commune"].length)].replace("{user}", "<@" + message.author.id + ">"));
            break;
        case "sing":
            message.channel.send("Ahh... this tune appeases us. Thank you. I grant unto thee the blessing of the Crimp for a day.");
            break;
        case "truth":
            message.channel.send("You wish to know the truth, " + message.author.username + "? How vain. Very well, we shall describe it for you. Your universe is nothing but p̷o̷i̵u̶y̵t̸r̴e̸w̵q̴a̵s̴d̶f̶g̸h̸j̶k̵l̸m̶n̶b̶v̵c̴x̷z̸. Pardon us, but it appears that we cannot put it into simple mortal terms. You'd best keep searching...");
            break;
        default:
            break;
    }
})

client.login("REDACTED")