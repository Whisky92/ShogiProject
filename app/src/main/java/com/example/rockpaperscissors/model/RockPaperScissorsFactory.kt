import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rockpaperscissors.model.RockPaperScissors

class RockPaperScissorsFactory(private var draws: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RockPaperScissors::class.java)) {
            return RockPaperScissors(draws) as T
        }
        throw IllegalArgumentException("An error occured")
    }

}