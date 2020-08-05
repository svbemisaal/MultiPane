import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multipaneview.*


class MainActivity : AppCompatActivity(), FragmentOptional.OnOptionClickListener {


    private var isTwoPane = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ((findViewById(R.id.detailContainer)) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, FragmentOptional())
                .commit()
        }

    }

    override fun onOptionSelected(option: String?) {


        if (isTwoPane) {

                when (option) {
                    "frontend" -> {
                        supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Frontend())
                            .commit()
                    }

                    "backend" -> {
                        supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Backend())
                            .commit()
                    }

                    "database" -> {
                        supportFragmentManager.beginTransaction().add(R.id.settingsContainer, Database())
                            .commit()
                    }
                }
        }


        else {

            val intent = Intent(this, Details::class.java)
            intent.putExtra("1", option)
            startActivity(intent)
        }

    }
}