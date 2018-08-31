# Tomato v0.2
**1 million estimated downloads!**

Welcome to the official page for the 2016's best hacked client for Minecraft! 

All source code is modular, however you must develop your own wrapper for MCP.

Client runs on version 1.8 of Minecraft.

![](https://i.imgur.com/WPJDo3Lg.jpg)

[RippedGaming release (250,000 views)](https://www.youtube.com/watch?v=hOODKCNqqEM)

[WizardHax release](https://www.wizardhax.com/2017/06/23/minecraft-tomato-client-1-8-x-hacked-client-download/)

[MPGH release](https://www.mpgh.net/forum/showthread.php?t=1102696)

## Backstory
I developed Tomato during the summer holidays right on the brink of my first year of high school, when I was around 13 years old. The goal was to create the sleekest and most advanced client to bypass any existing anticheat for Minecraft. 

Tomato 0.2 was initially never meant to be released publicly, instead I was planning on developing the client up to a marketable product which would be sold and updated constantly up to anticheat standards.

Around a few weeks into development, Tomato was in an excellent state as it skipped around the latest anticheat with ease. Through posting snippets of hollywood-style hacks on my channel I caught the attention of a few prominent people in the community - one of whom was RippedGaming. I decided to send a relatively reliable copy of Tomato to him as a sort of pre-alpha trial. With my permission, he gave Tomato away to two of his friends, one of which (called MissCartoon) decided to leak the client online.

As a result I asked Ripped to do a full online public release of the current version in order to prevent the leaker from gaining any credit - and voila! Tomato went viral and became one of the most used clients of 2016, helped with the fact it was shared extensively on Youtube on many videos with over ~100,000 views.

[Old Youtube Channel](https://www.youtube.com/channel/UC2Hb-pF_xXbh-pH97E2erJA) (remember I was 13 so expect a substatial amount of cringe)
## How did it work?

Developing bypasses for an anticheat is an interesting task which can become complex at times. The first step is to become totally familiar with the anticheat you are dealing with - in this case [NoCheatPlus](https://github.com/NoCheatPlus/NoCheatPlus), which was the gold standard of all anticheats during that period. If your hack bypassed NCP, you could do anything you wanted on any server. 

###  Fundamentals of NCP & Minecraft
Before we dive into any hollywood-style hacks, we need to understand the fundamentals of how NCP exactly works - and more importantly how your Minecraft client communicates with the server, and how your packets eventually translate through to the NCP plugin.


### Examples
#### Y-port speed

In Minecraft, standard old speeds increased your client tickspeed or timer in order to gain a small boost on the server-side. This sufficed for many people for a good three years.

However, at the time I thought that it was definitely not enough - as your speed had to stay within the range of NCP's checks, which made it quite unsatisfying. 

After some playing around, I realised I could emulate the fastest form of travel without block property interference in Minecraft - which was literally sprint jumping in between a two block wide gap. 

NCP's [SurvivalFly](https://github.com/NoCheatPlus/Docs/wiki/%5BMoving%5D-Survivalfly) check doesn't scan for blocks above you, which means you can quite sensibly pretend to have a line of blocks right above your head and zoom around. Using this knowledge and previous knowledge of adding a timer multiplier, we create this absolutely weirdly stunning speed - which in use looks like are bouncing up and down - hence the name "Y-port speed".

#### Full-block Downwards Phase

#to be continued


