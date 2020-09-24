// Skid Bot created by ZenIsBestWolf#0446.
// This is intended for one server only. Things may break if used in multiple servers.
// This also wasn't designed to be forked. Forking this and trying to use this in your server will cause issues!
const Discord = require('discord.js');
const client = new Discord.Client();
var token = process.env.TOKEN;
var prefix = "."
var zen = "183672121522782208"
var requestChannelID = "376485787245608970"
client.on('ready', () => {
	console.log('Skid Bot is online. Prefix is ' + prefix)
	client.user.setGame('being a skid.')
});
var memberTrackingChannelID = "376484628762198027"
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
		var role = args.join(' ').slice(args[0].length).trim().toLowerCase()
		switch (args[0].toLowerCase()) {
			case "addrole":
				switch (role) {
					case "android":
						if (message.member.roles.exists("name", "Android")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Android"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "bacon":
						message.reply(":smirk: Either you looked at the source code or you really wanted to know if there was a bacon role. God dammit.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "bot":
						message.reply(":x: You aren't a bot silly!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "furry":
						if (message.member.roles.exists("name", "Furry")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Furry"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "gamer":
						if (message.member.roles.exists("name", "Gamer")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Gamer"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "ios":
						if (message.member.roles.exists("name", "iOS")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "iOS"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "little boys":
						message.reply(":x: No one is eligible for this role.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "lol":
						if (message.member.roles.exists("name", "LoL")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "LoL"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "league of legends":
						if (message.member.roles.exists("name", "LoL")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "LoL"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "meme lord":
						if (message.member.roles.exists("name", "Meme Lord")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Meme Lord"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "muted":
						message.reply(":x: Trust me, you don\'t want that role.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						break;
					case "nintendo switch":
						if (message.member.roles.exists("name", "Nintendo Switch")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Nintendo Switch"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "overwatch":
						if (message.member.roles.exists("name", "Overwatch")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Overwatch"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "pc":
						if (message.member.roles.exists("name", "PC Master Race")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "PC Master Race"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "pc master race":
						if (message.member.roles.exists("name", "PC Master Race")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "PC Master Race"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "playstation":
						if (message.member.roles.exists("name", "PlayStation")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "PlayStation"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "roblox":
						if (message.member.roles.exists("name", "ROBLOX")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "ROBLOX"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "skid":
						message.reply(":x: Use ``.finish`` to add that role. :exclamation: **This will remove you from this channel and send you to the main chat.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "staff":
						message.reply(":x: We can\'t just give you the staff role!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "super skid":
						message.reply(":x: Only I can have that role!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "techie":
						if (message.member.roles.exists("name", "Techie")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Techie"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "weeb":
						if (message.member.roles.exists("name", "Weeb")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Weeb"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "weeaboo":
						if (message.member.roles.exists("name", "Weeb")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Weeb"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "wow":
						if (message.member.roles.exists("name", "WoW")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "WoW"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "world of warcraft":
						if (message.member.roles.exists("name", "WoW")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "WoW"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "xbox":
						if (message.member.roles.exists("name", "Xbox")) {
							message.reply(":x: You already have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.addRole(message.member.guild.roles.find("name", "Xbox"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					default:
						message.reply(":question: I can't find that role. Did you spell it right?").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
				};
				break;
			case "removerole":
				switch (role) {
					case "android":
						if (message.member.roles.exists("name", "Android")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Android"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "bacon":
						message.reply(":smirk: Either you looked at the source code or you really wanted to know if there was a bacon role. God dammit.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "bot":
						message.reply(":x: You aren't a bot silly!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "furry":
						if (message.member.roles.exists("name", "Furry")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Furry"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "gamer":
						if (message.member.roles.exists("name", "Gamer")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Gamer"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "ios":
						if (message.member.roles.exists("name", "iOS")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "iOS"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "little boys":
						message.reply(":x: No one is eligible for this role.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "lol":
						if (message.member.roles.exists("name", "LoL")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "LoL"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "league of legends":
						if (message.member.roles.exists("name", "LoL")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "LoL"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "meme lord":
						if (message.member.roles.exists("name", "Meme Lord")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Meme Lord"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "muted":
						message.reply(":x: You don't have that role, nor do you want it.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "nintendo switch":
						if (message.member.roles.exists("name", "Nintendo Switch")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Nintendo Switch"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "overwatch":
						if (message.member.roles.exists("name", "Overwatch")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Overwatch"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "pc":
						if (message.member.roles.exists("name", "PC Master Race")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "PC Master Race"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "pc master race":
						if (message.member.roles.exists("name", "PC Master Race")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "PC Master Race"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "playstation":
						if (message.member.roles.exists("name", "PlayStation")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "PlayStation"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "roblox":
						if (message.member.roles.exists("name", "ROBLOX")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "ROBLOX"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "skid":
						message.reply(":x: Use ``.finish`` to add that role. :exclamation: **This will remove you from this channel and send you to the main chat.").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "staff":
						message.reply(":x: We can\'t just give you the staff role!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "super skid":
						message.reply(":x: Only I can have that role!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "techie":
						if (message.member.roles.exists("name", "Techie")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Techie"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "weeb":
						if (message.member.roles.exists("name", "Weeb")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Weeb"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "weeaboo":
						if (message.member.roles.exists("name", "Weeb")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Weeb"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "wow":
						if (message.member.roles.exists("name", "WoW")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "WoW"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "world of warcraft":
						if (message.member.roles.exists("name", "WoW")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "WoW"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					case "xbox":
						if (message.member.roles.exists("name", "Xbox")) {
							message.reply(":x: You don't have that role!").then(e => setTimeout(function() {
								e.delete();
							}, 10000));
							message.delete();
							return;
						};
						message.member.removeRole(message.member.guild.roles.find("name", "Xbox"));
						message.reply(":white_check_mark: Role added!").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
						break;
					default:
						message.reply(":question: I can't find that role. Did you spell it right?").then(e => setTimeout(function() {
							e.delete();
						}, 10000));
						message.delete();
				};
				break;
			case "finish":
				message.member.addRole(message.member.guild.roles.find("name", "Skid"));
				message.delete();
				break;
			default:
				return;
		};
		return;
	};
	switch (args[0].toLowerCase()) {
		case "help":
			var helpEmbed = new Discord.RichEmbed().setThumbnail(client.user.avatarURL).setAuthor('Commands', client.user.avatarURL).setTitle('Command List').setDescription('Commands everyone can use.').setColor(0x1bb80f).addField(prefix + 'help - Sends this command.');
			message.author.send(helpEmbed)
			break;
	};
	if (message.author.id === zen) {
		switch (args[0].toLowerCase()) {
			case "famify":
				var fam = message.mentions.members.first();
				if (fam.roles.exists("name", "Little Boys")) {
					message.reply("That skid is already part of the :triumph::ok_hand::family::sunglasses: **FAM SQUAD** :sunglasses::family::ok_hand::triumph:");
					return;
				};
				message.channel.send(":triumph: :triumph: THROUGH THE POWER OF GRINDING :triumph: :triumph:").then(setTimeout(function() {
					message.channel.send(":ok_hand: :ok_hand: " + args[1] + " I HEAR BY DEEM YOU... :ok_hand:  :ok_hand:").then(setTimeout(function() {
						message.channel.send(":family: :family: :sunglasses: :sunglasses: PART OF THE FAM :sunglasses: :sunglasses: :family: :family:");
					}, 2000));
				}, 2000));
				fam.addRole(message.member.guild.roles.find("name", "Little Boys"));
				break;
		};
	};
});
client.login(token);
