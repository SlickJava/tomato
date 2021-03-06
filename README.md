# Tomato v0.2
**100,000 estimated downloads! (based on adf.ly and youtube)**

Welcome to the official page for 2016's best hacked client for Minecraft! 

All source code is modular, however you must develop your own wrapper for MCP.

Client runs on version 1.8 of Minecraft.

![](https://i.imgur.com/WPJDo3Lg.jpg)

[RippedGaming release (250,000 views)](https://www.youtube.com/watch?v=hOODKCNqqEM)

[WizardHax release](https://www.wizardhax.com/2017/06/23/minecraft-tomato-client-1-8-x-hacked-client-download/)

[MPGH release](https://www.mpgh.net/forum/showthread.php?t=1102696)

...and more, using the power of google

## Backstory
Tomato was developed during the summer holidays right on the brink of my first year of high school. The goal was to create a pretty sweet client to bypass any existing anticheat for Minecraft, with a nice UI.

Tomato 0.2 was initially never meant to be released as it was, but a few strange events happened along development which forced its release. So basically it was a three quarters done sort of thing which had some really cool stuff but was also kind of buggy.

Around a few weeks into development, Tomato was in a relatively on point state as it skipped around the latest anticheat with ease. Through posting snippets of some decently spicy hacks on my channel, I caught the attention of a few prominent people in the community - one of whom was called RippedGaming. I decided to send a relatively reliable copy of Tomato to him as a sort of pre-alpha trial. With my permission, he gave Tomato away to two of his friends, one of whom decided to leak the client online :(

As a result I asked Ripped to do a full online public release of the current version in order to prevent the leaker from gaining any credit - and voila! Tomato went viral and became one of the most used clients of 2016, helped with the fact it was shared extensively on Youtube on many videos with over ~100,000 views, with a combined total of around 2,500,000 total views today.


## How does it work?
#section in progress

Developing bypasses for an anticheat is an interesting task which can become really weird at times - and I really am not kidding, some of the ideas were really weird. The first step is to become totally familiar with the anticheat you are dealing with - in this case [NoCheatPlus](https://github.com/NoCheatPlus/NoCheatPlus), and the second step was to just brainstorm - if your hack bypassed NCP, it was very likely to bypass any server.

###  Fundamentals of NCP & Minecraft
Before we dive into any hollywood-style hacks, we need to understand the fundamentals of how NCP exactly works - and more importantly how your Minecraft client communicates with the server, and how your packets eventually translate through to the NCP plugin.


### Examples
#### Y-port speed

In Minecraft, standard old speeds increased your client tickspeed or timer in order to gain a small boost on the server-side. This sufficed for many people for a good three years.

However, at the time I thought that it was definitely not enough - as your speed had to stay within the range of NCP's checks, which made it quite unsatisfying. 

After some playing around, I realised I could emulate the fastest form of travel without block property interference in Minecraft - which was literally sprint jumping in between a two block wide gap.

NCP's [SurvivalFly](https://github.com/NoCheatPlus/Docs/wiki/%5BMoving%5D-Survivalfly) check doesn't scan for blocks above you, which means you can quite sensibly pretend to have a line of blocks right above your head and zoom around. Using this knowledge and previous knowledge of adding a timer multiplier, we create this absolutely weirdly stunning speed - which in use looks like are bouncing up and down - hence the name "Y-port speed".

#### Full-block Downwards Phase



