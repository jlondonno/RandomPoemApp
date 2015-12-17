# RandomPoemApp

This is Java app which parses the grammatical rules from a text file, then uses the parsed data to generate a random poem. Here is an example of what the output might look like:
	my sun among her white meadow
	moon upon my light
	moon
	your rain climbs
	her murky bright clear willow

The rules to generate the poem are the following:

POEM: <LINE> <LINE> <LINE> <LINE> <LINE>
LINE: <NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK
ADJECTIVE: black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END
NOUN: heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|tree|flower|field|meadow|pasture|harvest|water|father|mother|brother|sister <VERB>|<PREPOSITION>|$END
PRONOUN: my|your|his|her <NOUN>|<ADJECTIVE>
VERB: runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|$END
PREPOSITION: above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>
