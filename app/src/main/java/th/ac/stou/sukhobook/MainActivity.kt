package th.ac.stou.sukhobook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sign_in_btn = findViewById(R.id.signinBtn) as Button
        var login_panel = findViewById(R.id.login_panel) as LinearLayout
        sign_in_btn.setOnClickListener {
            login_panel.visibility = View.VISIBLE
        }

        var usernameTxt = findViewById(R.id.usernameTxt) as EditText
        var pwdTxt = findViewById(R.id.pwdTxt) as EditText
        var log_in_btn = findViewById(R.id.logInBtn) as Button
        log_in_btn.setOnClickListener {
            if (usernameTxt.text.toString()=="student"
                && pwdTxt.text.toString()=="test123")
            {
                Toast.makeText(this, "Log-In Successful!", Toast.LENGTH_LONG).show()
                usernameTxt.setText("")
                pwdTxt.setText("")
                login_panel.setVisibility(View.GONE)

                val i = Intent(this, MainShopActivity::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(this, "Incorrect Log-In!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
