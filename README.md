# MakeConnections
MakeConnections is a project I'm working on to learn more advanced AI concepts. It will (hopefully) be able to play a complete game of Connect 4 against a human player.

MakeConnections currently is only playable on the command line. In its current state two players can play a complete game of Connect 4, but there is no AI interaction. For the AI to challenge the player, a few things needs to take place:

### AI Requirements
* Create an algorithm to rate each chip on the board based on how many chips of the same color are near it / how possible it is to connect 4
* Rate the player's win % versus the computer's win %
* Play defensive or offensive moves based on whoever is in the lead?
* Tweak those requirements as required
