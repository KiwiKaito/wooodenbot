package channels.kaito

import clapCommand
import com.ktmi.tmi.dsl.builder.TwitchScope
import com.ktmi.tmi.dsl.builder.scopes.commands
import commandMark
import hugCommand
import unoCommand
import foodCommand
import goodnightCommand

fun TwitchScope.kaitoCommands() {

    commands(commandMark) {
        hugCommand()
        clapCommand()
        unoCommand()
        foodCommand()
        goodnightCommand()

        "commands" receive {
            sendMessage("You can call me using following commands: \"hug, clap, uno, sad, gn, food, treat \" CoolStoryBob")
        }

        "treat {value}" receive { parameters ->
            when(val treat = parameters.getValue("value").toLowerCase()) {
                "cat" -> sendMessage("Tinkerbell will now get a treat! \uD83D\uDC40")
                "dog" -> sendMessage("My Dogs will now get a treat! \uD83D\uDC40")
                else -> sendMessage("I don't have a $treat \uD83D\uDC40")
            }
        }
    }
}