# ZkjkMod
Minecraft mod for version 1.5.2 that backports some newer features, improves QoL and has other small changes.

Current features include:
* Skin support
* Commands:
  - Show Spawnpoint /showspawnpoint
  - Weather Forecast /forecast
* Config:
  - Log Rotation settings
  - Thunder toggle (basically just kills lightning bolts and stops them from being rendered. update: i noticed recently fire can still apear, i will work on it sometime.)
  - Far Entities settings (so you can see entities from bigger distance)
* Biomes and Worldgen:
  - Flower Forests (more birch and new flowers generate)
  - Deep Oceans (issue: rivers might not run into oceans. i had to fix rivers making outlines around deep oceans. more caves generate under deep oceans)
  - Dark Forest (added some cobweb, more spiders spawn in this biome and passive mobs don't spawn)
* New Flowers
  - Backported from 1.7 + Small Paeonia, Black Roses, Yellow Tulips and Carnation (issue: i fixed rose rendering in the flower pot, however you can't put any of the new flowers in it yet. i can only do a few with the limitation of that block, or change it completely how it works (like 1.7 did))
* Fishing Changes:
  - You can obtain enchanted books and xp bottles from fishing now (1/100)
  - Added garbage items to get from fishing (1/10)
  - You can get salmon (1/3) (issue: you cannot feed it to ocelots yet, also it uses another ID to the vanilla salmon added later (as damage value to regular fish) so it won't be compatible if you ever update your world)
* Coal Block
* Wheat Block
* Bone Block
* Dark Oak Wood
* Recipes for Stone Brick variants
* Wool bleaching (craft white wool from any other wool color)
* Fixed Disc 11
* Sit on stairs (can be toggled on and off)
* New Big Monster Rooms. You can find Fixed Disc 11 in there only.
* Strongholds everywhere in the world (Eyes of Ender still guide you to the 3 vanilla strongholds)
* Mineshafts are rarer (still more common than random strongholds)
* Enchanted Books from loot with multiple enchants (1/4 chance for every next enchant)
* Stronger Zombies and Skeletons
  - they now have the same chance for armor and enchanted equipment on all difficulty levels. their enchanted items use a curve now to determine their enchantment level - so now they can have op enchanted items, but it's more common they get bad enchants. to reward it there is a 1/1000 chance they will drop a random enchanted book.
  - new mob variant for zombies, skeletons and spiders - they can now spawn as minibosses and are way stronger (1/100)
  - baby zombies can now spawn naturally like in 1.6.2
* Beetroot seeds can now be obtained from zombies. the chance is 1/250
* Orebugs
  - very small chance to spawn from 'fortune'-type ores. it moves really quickly, has a lot of hp, but it doesn't attack the player, it just flees. hitting it drops some materials and killing it drops even more. you only have 100 seconds to kill it.
* Potion of Cloning
  - you can make it from magical beetroot (combine lapis lazuli with beetroot)
  - it will spawn a clone for 90/180 seconds that will fight for you
  - there are still a few issues regarding that. splash potion doesn't work. i also want to make it so that it will take the actual player's skin (there's no skin support so i skipped it for now)
* Old fire spreading
  - Fire spreads as fast as it did in Alpha and early Beta. Fire spreads slower in humid biomes (jungle and jungle hills) to prevent EXTREME lag
* Bigger Beacon range (100x100 instead of 50x50)

Unobtainable stuff (for now):
* Flowers: Poppy, Carnation, Small Paeonia, Black Rose
* Sponges

Planned features:
* More noteblock sounds
* More stuff in F3
* More potions
  - Potion of Fire (as splash starts fire around it)
* Runes. Unique enchantment, one per item

* Old Mushroom spreading
* New mushrooms
* Big spruce (backport from 1.7)
* New bosses
  - Skeleton Lord.
* Gardener Villager (selling different flowers)
* Musician Villager (selling jukebox, noteblocks and music discs, maybe instruments?)
* Instruments?
* DoublePlants (backport from 1.7)
* Gold Golem
* Diamond Golem
* More stuff in caves?
* More elaborate music system (with config and everything)
 
TO DO:
* Alerts on chat
* Gardener Villager
