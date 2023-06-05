package com.example.intentapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text
import java.net.URI

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnMoveActity: Button
    lateinit var btnMoveData: Button
    lateinit var btnMoveObject: Button
    lateinit var btnMoveDial: Button
    lateinit var btnMoveResult: Button
    lateinit var text: TextView
    lateinit var Intentku: ActivityResultLauncher<Intent>
    var aku: String = "Aku"
    var iyah: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iyah.putString("Nama","Fonda")
        iyah.putInt("Umur",16)
        iyah.putString("OK","Okeh")

        btnMoveActity = findViewById(R.id.btn_move_activity)
        btnMoveData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveObject = findViewById(R.id.btn_move_activity_with_object)
        btnMoveDial = findViewById(R.id.btn_dial_number)
        btnMoveResult = findViewById(R.id.btn_move_activity_with_result)
        text = findViewById(R.id.hasilText)

        btnMoveActity.setOnClickListener(this)
        btnMoveData.setOnClickListener(this)
        btnMoveObject.setOnClickListener(this)
        btnMoveDial.setOnClickListener(this)
        btnMoveResult.setOnClickListener(this)

        Intentku = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val dt = result.data!!.getStringExtra("Warna")
                Toast.makeText(applicationContext,dt,Toast.LENGTH_SHORT).show()
                if(dt == "Red"){
                    text.setTextColor(Color.parseColor("#FF0000"))
                    text.text = "Red"
                }else if(dt == "Green"){
                    text.setTextColor(Color.parseColor("#00FF00"))
                    text.text = "Green"
                }else if(dt == "Blue"){
                    text.setTextColor(Color.parseColor("#0000FF"))
                    text.text = "Blue"
                }
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, HasilActivity::class.java)
                startActivity(moveIntent)
            } R.id.btn_move_activity_with_data -> {
                val moveIntent = Intent(this@MainActivity, HasilActivity::class.java)
                moveIntent.putExtra("String", aku)
                startActivity(moveIntent)
            } R.id.btn_move_activity_with_object -> {
                val moveIntent = Intent(this@MainActivity, HasilActivity::class.java)
                moveIntent.putExtra("Bundle",iyah)
                startActivity(moveIntent)
            } R.id.btn_dial_number -> {
                val callMe = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"08982916070"))
                startActivity(callMe)
            } R.id.btn_move_activity_with_result -> {
                Intentku.launch(
                    Intent(this@MainActivity,OptionActivity::class.java)
                )
            }
        }
    }
}