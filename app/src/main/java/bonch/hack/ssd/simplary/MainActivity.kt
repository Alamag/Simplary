package bonch.hack.ssd.simplary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bonch.hack.ssd.simplary.databinding.ActivityMainBinding
import bonch.hack.ssd.simplary.router.Router
import bonch.hack.ssd.simplary.ui.main.FragmentMain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initFragment()
    }

    override fun onStart() {
        super.onStart()
        Router.setFragmentManager(supportFragmentManager)
    }

    override fun onPause() {
        Router.setFragmentManager(null)
        super.onPause()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainerView.id, FragmentMain())
            .commitAllowingStateLoss()
    }
}