package com.example.shogiproject

import RockPaperScissorsFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.rockpaperscissors.model.RockPaperScissors

class RpsGameFragment : Fragment() {

    val args: RpsGameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rps_game, container, false)

        val myName = args.name
        val textView = view.findViewById<TextView>(R.id.name_field)
        textView.setText(myName)

        val playerCount = view.findViewById<TextView>(R.id.player_wins)
        val botCount = view.findViewById<TextView>(R.id.bot_wins)
        val drawCount = view.findViewById<TextView>(R.id.draws)

        val playerFrame = view.findViewById<ImageView>(R.id.player_ch)
        val botFrame = view.findViewById<ImageView>(R.id.bot_ch)

        val rockImage = view.findViewById<ImageView>(R.id.rock_img)
        val paperImage = view.findViewById<ImageView>(R.id.paper_img)
        val scissorsImage = view.findViewById<ImageView>(R.id.scissors_img)

        val viewModelFactory = RockPaperScissorsFactory(5)
        var viewModel = ViewModelProvider(this, viewModelFactory).get(RockPaperScissors::class.java)

        fun getDrawableOfNumber(index: Int): Drawable {
            val drawables = arrayOf(rockImage.drawable, rockImage.drawable, paperImage.drawable, scissorsImage.drawable)
            return drawables[index]
        }

        viewModel.draws.observe( viewLifecycleOwner, Observer {
            drawCount.text = it.toString()
        })

        viewModel.playerWins.observe( viewLifecycleOwner, Observer {
            playerCount.text = it.toString()
        })

        viewModel.botWins.observe(viewLifecycleOwner, Observer {
            botCount.text = it.toString()
        })


        rockImage.setOnClickListener {
            val playerPick = 1
            playerFrame.setImageDrawable(getDrawableOfNumber(playerPick))
            val botPick = viewModel.rollBotNumber()
            botFrame.setImageDrawable(getDrawableOfNumber(botPick))
            viewModel.chooseWinner(playerPick, botPick)
        }

        paperImage.setOnClickListener {
            val playerPick = 2
            playerFrame.setImageDrawable(getDrawableOfNumber(playerPick))
            val botPick = viewModel.rollBotNumber()
            botFrame.setImageDrawable(getDrawableOfNumber(botPick))
            viewModel.chooseWinner(playerPick, botPick)
        }

        scissorsImage.setOnClickListener {
            val playerPick = 3
            playerFrame.setImageDrawable(getDrawableOfNumber(playerPick))
            val botPick = viewModel.rollBotNumber()
            botFrame.setImageDrawable(getDrawableOfNumber(botPick))
            viewModel.chooseWinner(playerPick, botPick)
        }








        return view
    }


}