package com.kadironcul.harry_potter_card_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_kayit_ol.*

class Kayit_Ol : AppCompatActivity() {
    var sayi=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit_ol)
        var database= FirebaseDatabase.getInstance().getReference("Kullanicilar")
        var getdata=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(k in snapshot.children)
                {
                    sayi=sayi+1
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)
    }
    fun Kayit_Ol_Kayit_Ol(view: View)
    {
        sayi=sayi+1
        textView5.text="ID : $sayi"
        var database= FirebaseDatabase.getInstance().getReference("Kullanicilar")
        var Okunan_Kullanici_Adi=kayit_Ol_Kullanici_Adi_Text.text.toString()
        var Okunan_Sifre=kayit_Ol_Sifre_Text.text.toString()
        var Okunan_E_Posta=kayit_Ol_E_Posta_Text.text.toString()
        if(Okunan_Kullanici_Adi.isNotEmpty() && Okunan_Sifre.isNotEmpty() && Okunan_E_Posta.isNotEmpty())
        {
            var kullanici=Kullanici(Okunan_Kullanici_Adi,Okunan_Sifre,Okunan_E_Posta)
            database.child(sayi.toString()).setValue(kullanici)
            textView5.text="ID : "
            kayit_Ol_Kullanici_Adi_Text.text.clear()
            kayit_Ol_Sifre_Text.text.clear()
            kayit_Ol_E_Posta_Text.text.clear()
            Toast.makeText(this,"Kayıt Başarılı", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Tüm Alanları Doldurunuz !!!", Toast.LENGTH_LONG).show()
        }
    }
    fun Kayit_Ol_Geri_Image(view: View)
    {
        val intent2= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent2)
        finish()
    }
}