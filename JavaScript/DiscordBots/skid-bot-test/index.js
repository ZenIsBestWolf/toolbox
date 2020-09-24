// Skid Bot created by ZenIsBestWolf#0446.
// This is intended for one server only. Things may break if used in multiple servers.
const Discord = require('discord.js');
const client = new Discord.Client();
var token = "redacted"
var prefix = "."
var zen = "183672121522782208"
var requestChannelID = "378667587510468608"
client.on('ready', () => {
	console.log('Skid Bot is online. Prefix is ' + prefix)
	client.user.setGame('being a skid.')
});
process.on('unhandledRejection', console.error);
var memberTrackingChannelID = "376581386540285963"
client.on('guildMemberAdd', member => {
	let guild = member.guild;
	guild.channels.get(memberTrackingChannelID).send(member + " has joined the server! Welcome!");
});
client.on('guildMemberRemove', member => {
	let guild = member.guild;
	guild.channels.get(memberTrackingChannelID).send(member + " has left. RIP!");
});
client.on('message', message => {
	if (!message.content.startsWith(prefix)) return;
	if (message.author.bot) return;
	var args = message.content.substring(prefix.length).split(" ");
	if (message.channel.id === requestChannelID) {
		var role = args.join(' ').slice(args[0].length).trim().toLowerCase();
		switch (args[0].toLowerCase()) {
			case "addrole":
				switch (role) {
					case "doorknob":
						if (message.member.roles.exists("name", "doorknob")) {
							message.reply(":x: You already have that role!")
							return;
						}
						message.member.addRole(message.member.guild.roles.find("name", "doorknob"));
						message.reply(":white_check_mark: Role added!")
						break;
					case "staff tt":
						message.reply(":x: I can't just *give* you the staff role!")
						break;
					default:
						message.reply(":question: I can't find that role. Did you spell it right?")
				}
				break;
			case "removerole":
				switch (args[1].toLowerCase()) {
					case "doorknob":
						if (!message.member.roles.exists("name", "doorknob")) {
							message.reply(":x: You don't have that role.")
							return;
						}
						message.member.removeRole(message.member.guild.roles.find("name", "doorknob"));
						message.reply(":white_check_mark: Role removed!")
						break;
					case "staff tt":
						message.reply("You shouldn\'t have the staff role silly!")
						break;
					default:
						message.reply(":question: I can't find that role. Did you spell it right?")
				}
				break;
			case "finish":
				message.member.removeRole(message.member.guild.roles.find("name", "Skid"));
				message.delete()
				break;
		};
	};
	switch (args[0]) {
		case "help":
			var helpEmbed = new Discord.RichEmbed().setThumbnail(client.user.avatarURL).setAuthor('Commands', client.user.avatarURL).setTitle('Command List').setDescription('Commands everyone can use.').setColor(0x1bb80f).addField(prefix + 'help - Sends this command.')
			message.reply(helpEmbed)
			break;
	};
	if (message.member.roles.exists("name", "Staff")) {
		console.log("Staff member " + message.author.username + " has called a command.")
		switch (args[0]) {
			case "purge":
				if (isNaN(args[1])) {
					message.reply("Invalid number to purge.").then(e => setTimeout(function() {
						e.delete();
					}, 20000));
					return;
				};
				if (args[1] > 100) {
					message.reply("The maximum value of messages you can purge is 100!").then(e => setTimeout(function() {
						e.delete();
					}, 20000));
					return;
				};
				if (args[1] < 1) {
					message.reply("The minimum value of messages you can purge is 1!").then(e => setTimeout(function() {
						e.delete();
					}, 20000));
					return;
				};
				var purgenum = args[1]
				message.channel.fetchMessages({
					limit: purgenum
				}).then(function(messages) {
					messages.deleteAll();
				});
				break;
		};
	};
	if (message.author.id === zen) {
		switch (args[0]) {
			case "famify":
				var fam = message.mentions.members.first();
				if (fam.roles.exists("name", "Staff")) {
					message.reply("That skid is already part of the :triumph::ok_hand::family::sunglasses: **FAM SQUAD** :sunglasses::family::ok_hand::triumph:")
					return;
				}
				message.channel.send(":triumph: :triumph: THROUGH THE POWER OF GRINDING :triumph: :triumph:").then(setTimeout(function() {
					message.channel.send(":ok_hand: :ok_hand: " + args[1] + " I HEAR BY DEEM YOU... :ok_hand:  :ok_hand:").then(setTimeout(function() {
						message.channel.send(":family: :family: :sunglasses: :sunglasses: PART OF THE FAM :sunglasses: :sunglasses: :family: :family:")
					}, 2000));
				}, 2000));
				fam.addRole(message.member.guild.roles.find("name", "Staff"))
				break;
			default:
		}
	}
});
client.login(token)
