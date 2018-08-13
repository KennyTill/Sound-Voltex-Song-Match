# SDVX Song Match

#### What is it?
SDVX Song Match is a simple lookup tool for the Japanese arcade game *Sound Voltex*.

#### Where is it?
The tool is currently hosted on AWS and can be found at [sdvx.info](http://sdvx.info)

#### How does it work?
The tool takes in two sets of values, commonly referred to as difficulties, for two players. It then intersects them to 
find a list of songs that fall between those numbers.

#### Who is it for?
This was primarily designed for a multiplayer match setting. It is simple enough to look up songs by difficulty for a 
single player, but trying to find a song that two players at different skill rankings can play at the same time can 
prove difficult.

#### What version of the game is this for?
Sound Voltex 4 - Heavenly Haven (the one currently in arcades)

#### The list of songs isn't complete!
Konami, the creators of Sound Voltex, add and remove new songs all the time. If you can point me to a list of updated 
songs and their difficulties that would be great. Alternatively, make a pull request on 
[songs.csv](https://github.com/KennyTill/Sound-Voltex-Song-Match/blob/master/src/main/resources/static/csv/songs.csv) 
and add it yourself. This will notify me and I can pull it in to a new build.

#### Other thoughts
This tool, in theory, could apply to any rhythm game with a numeric difficulty setting. 
Feel free to fork and make changes as needed, or give feedback. 

#### Long term goals
I have some better designs in mind, such as not serving static content out of my jar. An in memory database is currently
 being utilized as there are only about 300ish songs, but requires restarts between song additions/deletions. Moving 
 over to a proper database would allow me to add or remove songs without restarts.