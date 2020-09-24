const Discord = require('discord.js');
const client = new Discord.Client();
var token = "redacted"
var prefix = "thanos."
process.on('undhandledRejection', console.error);
client.on('ready', () => {
	console.log("Sniggty SNAPPING! Password for the gauntlet is " + prefix)
	client.user.setActivity("with my gauntlet.")
})
client.on('message', message => {
	if (message.author.bot) return;
	if (message.channel.type !== "text") {
		console.log(message.author.tag + " said: " + message)
	}
	if (!message.content.startsWith(prefix)) return;
	var args = message.content.substring(prefix.length).split(" ");
	var userPermLevel = 0
	if (message.author.id === "183672121522782208") userPermLevel = 1
	switch (args[0].toLowerCase()) {
		case "chat":
			if (userPermLevel < 1) {
				message.reply("You cannot use this command! This command is Level 1. You are Level " + userPermLevel + ".").then(e => setTimeout(function() {
					if (message.channel.type === "text") {
						e.delete();
						message.delete();
					};
				}, 10000));
				return;
			};
			var msg = args.join(' ').slice(args[0].length)
			message.channel.send(msg);
			if (message.channel.type === "text") message.delete();
			break;
		case "dm":
			if (userPermLevel < 1) return;
			var msg = args.join(' ').slice(args[0].length + args[1].length + 1)
			message.mentions.members.first().send(msg)
			if (message.channel.type === "text") message.delete()
	};
});
client.login(token)
