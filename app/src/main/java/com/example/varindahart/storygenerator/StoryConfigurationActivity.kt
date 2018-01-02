package com.example.varindahart.storygenerator

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_story_configuration.*

class SantaStoryConfiguration {
    val noun: String
    val verb: String
    val adjective1: String
    val adjective2: String

    constructor(noun: String, verb: String, adjective1: String, adjective2: String) {
        this.noun = noun
        this.verb = verb
        this.adjective1 = adjective1
        this.adjective2 = adjective2
    }
}

class SantaStory {
    val story: String

    constructor(configuration: SantaStoryConfiguration) {

        this.story = "Santa slid down ${configuration.noun}'s ${configuration.adjective1} chimney. " +
                "He laid out the amazon prime presents below the tree and " +
                "then ${configuration.verb} all of the ${configuration.adjective2} cookies! " +
                "Ho Ho Ho!"
    }

}

class StoryConfigurationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_configuration)
    }

    fun generateStory(view: View) {
        if (arrayOf(nounTextEntryView1,
                verbTextField,
                adjectiveTextField,
                adjectiveTextField2).noneAreBlank()) {
            val config = SantaStoryConfiguration(noun = nounTextEntryView1.text.toString(),
                    verb = verbTextField.text.toString(),
                    adjective1 = adjectiveTextField.text.toString(),
                    adjective2 = adjectiveTextField2.text.toString())

            val santaStory = SantaStory(config)

            showSantaStory(santaStory)
        }
    }

    fun showSantaStory(story: SantaStory) {
        AlertDialog.Builder(this).setTitle("Story!")
                .setMessage(story.story)
                .create()
                .show()
    }
}

fun Array<EditText>.noneAreBlank(): Boolean {
    for (field in this) {
        if (field.text.isBlank()) {
            return false
        }
    }
    return true
}