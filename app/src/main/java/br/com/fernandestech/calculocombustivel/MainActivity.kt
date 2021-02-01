package br.com.fernandestech.calculocombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{this.calculate() }

    }

    private fun calculate(){

        val distance = editDistance.text.toString()
        val price = editPrice.text.toString()
        val autonomy = editAutonomy.text.toString()

        try{
            if(validation(distance, price, autonomy)){
                val totalValue = ((distance.toFloat() * price.toFloat()) / autonomy.toFloat());
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            }
        }catch (exception: Exception){
            Toast.makeText(this, "Verifique todos os campos e tente novamente!", Toast.LENGTH_LONG).show();
        }



    }

    private fun validation(distance: String, price: String, autonomy: String): Boolean {

        if(distance.isNullOrEmpty()){
            Toast.makeText(this, "Verifique a distancia e tente novamente!", Toast.LENGTH_LONG).show();
            return false;
        }
        if(price.isNullOrEmpty()){
            Toast.makeText(this, "Verifique o preço e tente novamente!", Toast.LENGTH_LONG).show();
            return false;
        }
        if(autonomy.isNullOrEmpty() || autonomy.toFloat() < 1){
            Toast.makeText(this, "Verifique a autonomia e tente novamente!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}