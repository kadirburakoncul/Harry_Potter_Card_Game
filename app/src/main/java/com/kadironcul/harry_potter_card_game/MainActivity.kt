package com.kadironcul.harry_potter_card_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Main_Giris_Yap_Button(view : View) {
        val intent1= Intent(applicationContext,Giris::class.java)
        startActivity(intent1)
        finish()
    }
    fun Main_Kayıt_Ol_Button(view : View) {
        val intent1= Intent(applicationContext,Kayit_Ol::class.java)
        startActivity(intent1)
        finish()
    }
    fun Database_Resim_Bilgisi_Ekleme()
    {
        var database= FirebaseDatabase.getInstance().getReference("Resimler")
        var resimler1=Resimler("Albus Dumbledore","GRYFFİNDOR","20"," ")
        var resimler2=Resimler("Rubeus Hagrid","GRYFFİNDOR","12"," ")
        var resimler3=Resimler("Minerva McGonagall","GRYFFİNDOR","13"," ")
        var resimler4=Resimler("Arthur Weasley","GRYFFİNDOR","10"," ")
        var resimler5=Resimler("Sirius Black","GRYFFİNDOR","18"," ")
        var resimler6=Resimler("Lily Potter","GRYFFİNDOR","12"," ")
        var resimler7=Resimler("Remus Lupin","GRYFFİNDOR","10"," ")
        var resimler8=Resimler("Peter Pettigrew","GRYFFİNDOR","5"," ")
        var resimler9=Resimler("Harry Potter","GRYFFİNDOR","10"," ")
        var resimler10=Resimler("Ron Weasley","GRYFFİNDOR","8"," ")
        var resimler11=Resimler("Hermione Granger","GRYFFİNDOR","10"," ")

        var resimler12=Resimler("Tom Riddle","SLYTHERİN","20"," ")
        var resimler13=Resimler("Horace Slughorn","SLYTHERİN","12"," ")
        var resimler14=Resimler("Bellatrix Lestrange","SLYTHERİN","13"," ")
        var resimler15=Resimler("Narcissa Malfoy","SLYTHERİN","10"," ")
        var resimler16=Resimler("Andromeda Tonks","SLYTHERİN","16"," ")
        var resimler17=Resimler("Lucius Malfoy","SLYTHERİN","12"," ")
        var resimler18=Resimler("Evan Rosier","SLYTHERİN","10"," ")
        var resimler19=Resimler("Draco Malfoy","SLYTHERİN","5"," ")
        var resimler20=Resimler("Dolores Umbridge","SLYTHERİN","10"," ")
        var resimler21=Resimler("Severus Snape","SLYTHERİN","18"," ")
        var resimler22=Resimler("Leta Lestrange","SLYTHERİN","10"," ")

        var resimler23=Resimler("Rowena Ravenclaw","RAVENCLAW","20"," ")
        var resimler24=Resimler("Luna Lovegood","RAVENCLAW","9"," ")
        var resimler25=Resimler("Gilderoy Lockhart","RAVENCLAW","13"," ")
        var resimler26=Resimler("Filius Flitwick","RAVENCLAW","10"," ")
        var resimler27=Resimler("Cho Chang","RAVENCLAW","11"," ")
        var resimler28=Resimler("Sybill Trelawney","RAVENCLAW","14"," ")
        var resimler29=Resimler("Marcus Belby","RAVENCLAW","10"," ")
        var resimler30=Resimler("Myrtle Warren","RAVENCLAW","5"," ")
        var resimler31=Resimler("Padma Patil","RAVENCLAW","10"," ")
        var resimler32=Resimler("Quirinus Quirrell","RAVENCLAW","15"," ")
        var resimler33=Resimler("Garrick Ollivander","RAVENCLAW","15"," ")

        var resimler34=Resimler("Helga Hufflepuff","HUFFLEPUFF","20"," ")
        var resimler35=Resimler("Cedric Diggory","HUFFLEPUFF","18"," ")
        var resimler36=Resimler("Nymphadora Tonks","HUFFLEPUFF","14"," ")
        var resimler37=Resimler("Pomona Sprout","HUFFLEPUFF","10"," ")
        var resimler38=Resimler("Newt Scamander","HUFFLEPUFF","18"," ")
        var resimler39=Resimler("Fat Friar","HUFFLEPUFF","12"," ")
        var resimler40=Resimler("Hannah Abbott","HUFFLEPUFF","10"," ")
        var resimler41=Resimler("Ernest Macmillan","HUFFLEPUFF","5"," ")
        var resimler42=Resimler("Leanne","HUFFLEPUFF","10"," ")
        var resimler43=Resimler("Silvanus Kettleburn","HUFFLEPUFF","12"," ")
        var resimler44=Resimler("Ted Lupin","HUFFLEPUFF","10"," ")

        var imageArray=ArrayList<Resimler>()
        imageArray.add(resimler1)
        imageArray.add(resimler2)
        imageArray.add(resimler3)
        imageArray.add(resimler4)
        imageArray.add(resimler5)
        imageArray.add(resimler6)
        imageArray.add(resimler7)
        imageArray.add(resimler8)
        imageArray.add(resimler9)
        imageArray.add(resimler10)
        imageArray.add(resimler11)
        imageArray.add(resimler12)
        imageArray.add(resimler13)
        imageArray.add(resimler14)
        imageArray.add(resimler15)
        imageArray.add(resimler16)
        imageArray.add(resimler17)
        imageArray.add(resimler18)
        imageArray.add(resimler19)
        imageArray.add(resimler20)
        imageArray.add(resimler21)
        imageArray.add(resimler22)
        imageArray.add(resimler23)
        imageArray.add(resimler24)
        imageArray.add(resimler25)
        imageArray.add(resimler26)
        imageArray.add(resimler27)
        imageArray.add(resimler28)
        imageArray.add(resimler29)
        imageArray.add(resimler30)
        imageArray.add(resimler31)
        imageArray.add(resimler32)
        imageArray.add(resimler33)
        imageArray.add(resimler34)
        imageArray.add(resimler35)
        imageArray.add(resimler36)
        imageArray.add(resimler37)
        imageArray.add(resimler38)
        imageArray.add(resimler39)
        imageArray.add(resimler40)
        imageArray.add(resimler41)
        imageArray.add(resimler42)
        imageArray.add(resimler43)
        imageArray.add(resimler44)

        for(k in(0..43))
        {
            database.child((k+1).toString()).setValue(imageArray[k])
        }
    }
}