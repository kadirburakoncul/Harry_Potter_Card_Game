package com.kadironcul.harry_potter_card_game

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_oyun6lik.*

class Oyun_6lik : AppCompatActivity() {
    var Alinan_Veri_Oyuncu_Sayisi=0
    var Alinan_Veri_Kullanici_Adi:String=""
    var Alinan_Veri_Sifre:String=""
    var DB_Isimler=ArrayList<String>()
    var DB_Evler=ArrayList<String>()
    var DB_Puanlar=ArrayList<Int>()
    var Resim_Dizisi=ArrayList<Bitmap>()
    var st:String=""
    var imageArray=ArrayList<ImageView>()
    var imageArray_Kapali=ArrayList<ImageView>()
    var Dolu_Imageler=IntArray(36)
    var Kullanilan_Resimler=IntArray(44)
    var Imagelere_Atanan_Isimler=ArrayList<String>()
    var Imagelere_Atanan_Evler=ArrayList<String>()
    var Imagelere_Atanan_Ev_Katsayi=IntArray(36)
    var Imagelere_Atanan_Puanlar=IntArray(36)
    var Imagelere_Atanan_Resimler=IntArray(36)
    var Birinci_Oyuncu_Puani=0.0f
    var Ikinci_Oyuncu_Puani=0.0f
    var imageArray_Sayi_Dizisi=IntArray(36)
    var imageArray_Kapali_Sayi_Dizisi=IntArray(36)
    var kalan_sure:Float=0.0f
    var sure1=45.0f
    var sure2=60.0f
    var acilan_kart_kontrolu=ArrayList<Int>()
    var Oyun_Sira_Hakki=1
    var ev1=0
    var ev2=0
    var ev3=0
    var ev4=0
    var mediaplayer_oyun_boyunca_calan_muzik: MediaPlayer?=null
    var mediaplayer_oyun_dogru_eslesmede_muzik: MediaPlayer?=null
    var mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik: MediaPlayer?=null
    var mediaplayer_oyun_sure_bittiginde_calan_muzik: MediaPlayer?=null
    var atama_degeri=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun6lik)
        ///////////////////////////////////////////////////////////////
        Baslat_Butonu_6lik.visibility=View.INVISIBLE
        ///////////////////////////////////////////////////////////////
        imageArray.add(image1_6lik);
        imageArray.add(image2_6lik);
        imageArray.add(image3_6lik);
        imageArray.add(image4_6lik);
        imageArray.add(image5_6lik);
        imageArray.add(image6_6lik);
        imageArray.add(image7_6lik);
        imageArray.add(image8_6lik);
        imageArray.add(image9_6lik);
        imageArray.add(image10_6lik);
        imageArray.add(image11_6lik);
        imageArray.add(image12_6lik);
        imageArray.add(image13_6lik);
        imageArray.add(image14_6lik);
        imageArray.add(image15_6lik);
        imageArray.add(image16_6lik);
        imageArray.add(image17_6lik);
        imageArray.add(image18_6lik);
        imageArray.add(image19_6lik);
        imageArray.add(image20_6lik);
        imageArray.add(image21_6lik);
        imageArray.add(image22_6lik);
        imageArray.add(image23_6lik);
        imageArray.add(image24_6lik);
        imageArray.add(image25_6lik);
        imageArray.add(image26_6lik);
        imageArray.add(image27_6lik);
        imageArray.add(image28_6lik);
        imageArray.add(image29_6lik);
        imageArray.add(image30_6lik);
        imageArray.add(image31_6lik);
        imageArray.add(image32_6lik);
        imageArray.add(image33_6lik);
        imageArray.add(image34_6lik);
        imageArray.add(image35_6lik);
        imageArray.add(image36_6lik);
        imageArray_Kapali.add(image1_6lik_kapali)
        imageArray_Kapali.add(image2_6lik_kapali)
        imageArray_Kapali.add(image3_6lik_kapali)
        imageArray_Kapali.add(image4_6lik_kapali)
        imageArray_Kapali.add(image5_6lik_kapali)
        imageArray_Kapali.add(image6_6lik_kapali)
        imageArray_Kapali.add(image7_6lik_kapali)
        imageArray_Kapali.add(image8_6lik_kapali)
        imageArray_Kapali.add(image9_6lik_kapali)
        imageArray_Kapali.add(image10_6lik_kapali)
        imageArray_Kapali.add(image11_6lik_kapali)
        imageArray_Kapali.add(image12_6lik_kapali)
        imageArray_Kapali.add(image13_6lik_kapali)
        imageArray_Kapali.add(image14_6lik_kapali)
        imageArray_Kapali.add(image15_6lik_kapali)
        imageArray_Kapali.add(image16_6lik_kapali)
        imageArray_Kapali.add(image17_6lik_kapali)
        imageArray_Kapali.add(image18_6lik_kapali)
        imageArray_Kapali.add(image19_6lik_kapali)
        imageArray_Kapali.add(image20_6lik_kapali)
        imageArray_Kapali.add(image21_6lik_kapali)
        imageArray_Kapali.add(image22_6lik_kapali)
        imageArray_Kapali.add(image23_6lik_kapali)
        imageArray_Kapali.add(image24_6lik_kapali)
        imageArray_Kapali.add(image25_6lik_kapali)
        imageArray_Kapali.add(image26_6lik_kapali)
        imageArray_Kapali.add(image27_6lik_kapali)
        imageArray_Kapali.add(image28_6lik_kapali)
        imageArray_Kapali.add(image29_6lik_kapali)
        imageArray_Kapali.add(image30_6lik_kapali)
        imageArray_Kapali.add(image31_6lik_kapali)
        imageArray_Kapali.add(image32_6lik_kapali)
        imageArray_Kapali.add(image33_6lik_kapali)
        imageArray_Kapali.add(image34_6lik_kapali)
        imageArray_Kapali.add(image35_6lik_kapali)
        imageArray_Kapali.add(image36_6lik_kapali)
        ///////////////////////////////////////////////////////////////
        for(image in imageArray){
            image.visibility= View.INVISIBLE
        }
        for(image in imageArray_Kapali){
            image.visibility= View.INVISIBLE
        }
        ///////////////////////////////////////////////////////////////
        kalan_sure_text_6lik.visibility=View.INVISIBLE
        birinci_oyuncu_skor_text_6lik.visibility=View.INVISIBLE
        ikinci_oyuncu_skor_text_6lik.visibility=View.INVISIBLE
        Oyun_6lik_Ipucu_Text.visibility=View.INVISIBLE
        Oyun_6lik_kapat_Image.visibility=View.INVISIBLE
        Oyun_6lik_Ipucu_Image.visibility=View.VISIBLE
        ///////////////////////////////////////////////////////////////
        Resimleri_Databaseden_Cek_6lik()
    }
    fun Resimleri_Databaseden_Cek_6lik()
    {
        var database= FirebaseDatabase.getInstance().getReference("Resimler")
        var getdata=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (k in snapshot.children) {
                    var DB_Okunan_Resim_Isim=k.child("resim_Adi").getValue()
                    var DB_Okunan_Resim_Ev=k.child("resim_Evi").getValue()
                    var DB_Okunan_Resim_Puani=k.child("resim_Puani").getValue()
                    var VT_Okunan_Resim_Base64=k.child("resim_Base64").getValue()
                    st=(VT_Okunan_Resim_Base64.toString())
                    var resimByte = Base64.decode(st, 0)
                    var resim = BitmapFactory.decodeByteArray(resimByte, 0, resimByte.size)

                    Resim_Dizisi.add(resim)
                    DB_Isimler.add(DB_Okunan_Resim_Isim.toString())
                    DB_Evler.add(DB_Okunan_Resim_Ev.toString())
                    DB_Puanlar.add(DB_Okunan_Resim_Puani.toString().toInt())
                    if(Resim_Dizisi.count()==44)
                    {
                        Diger_Baslangic_Islemleri_6lik()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)
    }
    fun Diger_Baslangic_Islemleri_6lik()
    {
        for(k in (0..35))
        {
            Dolu_Imageler[k]=0
            imageArray_Sayi_Dizisi[k]=0
            imageArray_Kapali_Sayi_Dizisi[k]=0
            Imagelere_Atanan_Isimler.add(" ")
            Imagelere_Atanan_Evler.add(" ")
        }
        for(k in (0..43))
        {
            Kullanilan_Resimler[k]=0
        }

        val intent = intent
        Alinan_Veri_Oyuncu_Sayisi = intent.getIntExtra("Yollanan_Veri_Oyuncu_Sayisi",-1)
        Alinan_Veri_Kullanici_Adi = intent.getStringExtra("Yollanan_Veri_Kullanici_Adi").toString()
        Alinan_Veri_Sifre = intent.getStringExtra("Yollanan_Veri_Sifre").toString()
        ///////////////////////////////////////////////////////////////
        Toast.makeText(applicationContext,"Oyun Yüklendi", Toast.LENGTH_SHORT).show()
        Baslat_Butonu_6lik.visibility=View.VISIBLE
    }
    fun Baslat_6lik(view:View)
    {
        mediaplayer_oyun_boyunca_calan_muzik = MediaPlayer.create(this, R.raw.oyun_boyunca_calan_muzik)
        mediaplayer_oyun_dogru_eslesmede_muzik = MediaPlayer.create(this, R.raw.oyun_dogru_eslesmede_calan_muzik)
        mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik = MediaPlayer.create(this, R.raw.oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik)
        mediaplayer_oyun_sure_bittiginde_calan_muzik = MediaPlayer.create(this, R.raw.oyun_suresi_bittiginde_calan_muzik)
        mediaplayer_oyun_boyunca_calan_muzik?.start()
        var katsayi=0
        var rastgele_resim=0
        while(ev1!=4)
        {
            while (true)
            {
                rastgele_resim = (0..10).random()
                if(Kullanilan_Resimler[rastgele_resim]==0)
                {
                    Kullanilan_Resimler[rastgele_resim]=1
                    katsayi=2
                    break
                }
            }
            for(k in(0..1))
            {
                while(true)
                {
                    var atanacak_image_degeri=(0..35).random()
                    if(Dolu_Imageler[atanacak_image_degeri]==0)
                    {
                        Imagelere_Atanan_Isimler[atanacak_image_degeri]=(DB_Isimler[rastgele_resim+1])
                        Imagelere_Atanan_Evler[atanacak_image_degeri]=(DB_Evler[rastgele_resim+1])
                        Imagelere_Atanan_Puanlar[atanacak_image_degeri]=(DB_Puanlar[rastgele_resim+1])
                        Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]=katsayi
                        Imagelere_Atanan_Resimler[atanacak_image_degeri]=Imagelere_Atanan_Isimler.count()
                        imageArray[atanacak_image_degeri].setImageBitmap(Resim_Dizisi[rastgele_resim])
                        Dolu_Imageler[atanacak_image_degeri]=1
                        atama_degeri=atanacak_image_degeri.toInt()+1
                        Oyun_6lik_Ipucu_Text.text=Oyun_6lik_Ipucu_Text.text.toString()+"\n"+atama_degeri.toString() + ".Resim=İsim:"+Imagelere_Atanan_Isimler[atanacak_image_degeri]+
                                ",Puan:"+Imagelere_Atanan_Puanlar[atanacak_image_degeri]+
                                ",Ev:"+Imagelere_Atanan_Evler[atanacak_image_degeri]+
                                ",Ev Katsayı:"+Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]
                        break
                    }
                }
            }
            ev1=ev1+1
        }
        while(ev2!=4)
        {
            while (true)
            {
                rastgele_resim = (11..21).random()
                if(Kullanilan_Resimler[rastgele_resim]==0)
                {
                    Kullanilan_Resimler[rastgele_resim]=1
                    katsayi=2
                    break
                }
            }
            for(k in(0..1))
            {
                while(true)
                {
                    var atanacak_image_degeri=(0..35).random()
                    if(Dolu_Imageler[atanacak_image_degeri]==0)
                    {
                        Imagelere_Atanan_Isimler[atanacak_image_degeri]=(DB_Isimler[rastgele_resim+1])
                        Imagelere_Atanan_Evler[atanacak_image_degeri]=(DB_Evler[rastgele_resim+1])
                        Imagelere_Atanan_Puanlar[atanacak_image_degeri]=(DB_Puanlar[rastgele_resim+1])
                        Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]=katsayi
                        Imagelere_Atanan_Resimler[atanacak_image_degeri]=Imagelere_Atanan_Isimler.count()
                        imageArray[atanacak_image_degeri].setImageBitmap(Resim_Dizisi[rastgele_resim])
                        Dolu_Imageler[atanacak_image_degeri]=1
                        atama_degeri=atanacak_image_degeri.toInt()+1
                        Oyun_6lik_Ipucu_Text.text=Oyun_6lik_Ipucu_Text.text.toString()+"\n"+atama_degeri.toString() + ".Resim=İsim:"+Imagelere_Atanan_Isimler[atanacak_image_degeri]+
                                ",Puan:"+Imagelere_Atanan_Puanlar[atanacak_image_degeri]+
                                ",Ev:"+Imagelere_Atanan_Evler[atanacak_image_degeri]+
                                ",Ev Katsayı:"+Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]
                        break
                    }
                }
            }
            ev2=ev2+1
        }
        while(ev3!=5)
        {
            while (true)
            {
                rastgele_resim = (22..32).random()
                if(Kullanilan_Resimler[rastgele_resim]==0)
                {
                    Kullanilan_Resimler[rastgele_resim]=1
                    katsayi=1
                    break
                }
            }
            for(k in(0..1))
            {
                while(true)
                {
                    var atanacak_image_degeri=(0..35).random()
                    if(Dolu_Imageler[atanacak_image_degeri]==0)
                    {
                        Imagelere_Atanan_Isimler[atanacak_image_degeri]=(DB_Isimler[rastgele_resim+1])
                        Imagelere_Atanan_Evler[atanacak_image_degeri]=(DB_Evler[rastgele_resim+1])
                        Imagelere_Atanan_Puanlar[atanacak_image_degeri]=(DB_Puanlar[rastgele_resim+1])
                        Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]=katsayi
                        Imagelere_Atanan_Resimler[atanacak_image_degeri]=Imagelere_Atanan_Isimler.count()
                        imageArray[atanacak_image_degeri].setImageBitmap(Resim_Dizisi[rastgele_resim])
                        Dolu_Imageler[atanacak_image_degeri]=1
                        atama_degeri=atanacak_image_degeri.toInt()+1
                        Oyun_6lik_Ipucu_Text.text=Oyun_6lik_Ipucu_Text.text.toString()+"\n"+atama_degeri.toString() + ".Resim=İsim:"+Imagelere_Atanan_Isimler[atanacak_image_degeri]+
                                ",Puan:"+Imagelere_Atanan_Puanlar[atanacak_image_degeri]+
                                ",Ev:"+Imagelere_Atanan_Evler[atanacak_image_degeri]+
                                ",Ev Katsayı:"+Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]
                        break
                    }
                }
            }
            ev3=ev3+1
        }
        while(ev4!=5)
        {
            while (true)
            {
                rastgele_resim = (33..43).random()
                if(Kullanilan_Resimler[rastgele_resim]==0)
                {
                    Kullanilan_Resimler[rastgele_resim]=1
                    katsayi=1
                    break
                }
            }
            for(k in(0..1))
            {
                while(true)
                {
                    var atanacak_image_degeri=(0..35).random()
                    if(Dolu_Imageler[atanacak_image_degeri]==0)
                    {
                        Imagelere_Atanan_Isimler[atanacak_image_degeri]=(DB_Isimler[rastgele_resim+1])
                        Imagelere_Atanan_Evler[atanacak_image_degeri]=(DB_Evler[rastgele_resim+1])
                        Imagelere_Atanan_Puanlar[atanacak_image_degeri]=(DB_Puanlar[rastgele_resim+1])
                        Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]=katsayi
                        Imagelere_Atanan_Resimler[atanacak_image_degeri]=Imagelere_Atanan_Isimler.count()
                        imageArray[atanacak_image_degeri].setImageBitmap(Resim_Dizisi[rastgele_resim])
                        Dolu_Imageler[atanacak_image_degeri]=1
                        atama_degeri=atanacak_image_degeri.toInt()+1
                        Oyun_6lik_Ipucu_Text.text=Oyun_6lik_Ipucu_Text.text.toString()+"\n"+atama_degeri.toString() + ".Resim= İsim:"+Imagelere_Atanan_Isimler[atanacak_image_degeri]+
                                ",Puan:"+Imagelere_Atanan_Puanlar[atanacak_image_degeri]+
                                ",Ev:"+Imagelere_Atanan_Evler[atanacak_image_degeri]+
                                ",Ev Katsayı:"+Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]
                        break
                    }
                }
            }
            ev4=ev4+1
        }

        for(image in imageArray_Kapali){
            image.visibility= View.VISIBLE
        }
        kalan_sure_text_6lik.visibility=View.VISIBLE
        birinci_oyuncu_skor_text_6lik.visibility=View.VISIBLE
        Baslat_Butonu_6lik.visibility=View.INVISIBLE
        if(Alinan_Veri_Oyuncu_Sayisi==1)
        {
            kalan_sure_text_6lik.text="KALAN SÜRE : 45"
            object : CountDownTimer(45000,1000)
            {
                override fun onTick(p0: Long) {
                    kalan_sure_text_6lik.text="KALAN SÜRE : "+p0/1000
                    kalan_sure= (p0/1000).toFloat()
                }

                override fun onFinish() {
                    kalan_sure_text_6lik.text="KALAN SÜRE : 0"
                    Mesaj_6lik()
                    mediaplayer_oyun_boyunca_calan_muzik?.stop()
                    mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
                    mediaplayer_oyun_sure_bittiginde_calan_muzik?.start()
                }

            }.start()
        }
        else if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            ikinci_oyuncu_skor_text_6lik.visibility=View.VISIBLE
            kalan_sure_text_6lik.text="KALAN SÜRE : 60"
            object : CountDownTimer(60000,1000)
            {
                override fun onTick(p0: Long) {
                    kalan_sure_text_6lik.text="KALAN SÜRE : "+p0/1000
                    kalan_sure= (p0/1000).toFloat()
                }

                override fun onFinish() {
                    kalan_sure_text_6lik.text="KALAN SÜRE : 0"
                    Mesaj_6lik()
                    mediaplayer_oyun_boyunca_calan_muzik?.stop()
                    mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
                    mediaplayer_oyun_sure_bittiginde_calan_muzik?.start()
                }

            }.start()
        }
    }
    fun Mesaj_6lik()
    {
        var UyariMesaji= AlertDialog.Builder(this@Oyun_6lik)
        UyariMesaji.setTitle("                  OYUN BİTTİ")
        if(Alinan_Veri_Oyuncu_Sayisi==1)
        {
            UyariMesaji.setMessage("Oyun Skoru : $Birinci_Oyuncu_Puani \nTekrar Oynamak İster misiniz?")
        }
        else if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            UyariMesaji.setMessage("1.Oyuncu Skoru : $Birinci_Oyuncu_Puani \n 2.Oyuncu Skoru : $Ikinci_Oyuncu_Puani \nTekrar Oynamak İster misiniz?")
        }
        UyariMesaji.setPositiveButton("Evet", DialogInterface.OnClickListener{ dialogInterface, i ->
            Toast.makeText(applicationContext,"Oyun Yeniden Başlıyor.", Toast.LENGTH_SHORT).show()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            val intent2= Intent(applicationContext,Giris_Yap_Menu::class.java)
            intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
            intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
            startActivity(intent2)
            finish()
        })
        UyariMesaji.setNegativeButton("Hayır", DialogInterface.OnClickListener{ dialogInterface, i ->
            Toast.makeText(applicationContext,"Menüye Dönülüyor", Toast.LENGTH_SHORT).show()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            val intent2= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent2)
            finish()
        })
        UyariMesaji.show()
    }
    fun Resim_Ac_Kapa(deger:Int)
    {
        acilan_kart_kontrolu.add(deger-1)
        if(acilan_kart_kontrolu.count()==2)
        {
            object : CountDownTimer(1000,1000)
            {
                override fun onTick(a: Long) {
                    imageArray[deger-1].visibility= View.VISIBLE
                    imageArray_Kapali[deger-1].visibility= View.INVISIBLE
                }

                override fun onFinish() {
                    acilan_kart_kontrolu_function_6lik()
                }

            }.start()
        }
        else
        {
            imageArray[deger-1].visibility= View.VISIBLE
            imageArray_Kapali[deger-1].visibility= View.INVISIBLE
        }
    }
    fun Tum_Kartlar_Acildimi_Kontrol_6lik()
    {
        var sayi=0
        for(k in (0..35))
        {
            if(imageArray_Sayi_Dizisi[k]==1)
            {
                sayi+=1
            }
        }
        if(sayi==36)
        {
            Mesaj_6lik()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.start()
        }
    }
    fun acilan_kart_kontrolu_function_6lik(){
        if(Imagelere_Atanan_Isimler[acilan_kart_kontrolu[0]]==Imagelere_Atanan_Isimler[acilan_kart_kontrolu[1]])
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                Birinci_Oyuncu_Puani+=((2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]])*(kalan_sure/10)).toFloat()
                Oyun_Sira_Hakki=1
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani+=(2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani+=(2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
            }
            mediaplayer_oyun_boyunca_calan_muzik?.pause()
            mediaplayer_oyun_dogru_eslesmede_muzik?.start()
            object : CountDownTimer(3000,1000)
            {
                override fun onTick(p0: Long) {
                }
                override fun onFinish() {
                    mediaplayer_oyun_dogru_eslesmede_muzik?.pause()
                    mediaplayer_oyun_boyunca_calan_muzik?.start()
                }

            }.start()
            imageArray_Sayi_Dizisi[acilan_kart_kontrolu[0]]=1
            imageArray_Sayi_Dizisi[acilan_kart_kontrolu[1]]=1
            imageArray_Kapali_Sayi_Dizisi[acilan_kart_kontrolu[0]]=1
            imageArray_Kapali_Sayi_Dizisi[acilan_kart_kontrolu[1]]=1
            Tum_Kartlar_Acildimi_Kontrol_6lik()
        }
        else if(Imagelere_Atanan_Evler[acilan_kart_kontrolu[0]]==Imagelere_Atanan_Evler[acilan_kart_kontrolu[1]])
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]])*((sure1-kalan_sure)/10)).toFloat()
                    Oyun_Sira_Hakki = 1
                }
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani-=((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
        }
        else
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=((((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]])*((sure1-kalan_sure)/10)).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
        }
        birinci_oyuncu_skor_text_6lik.text="1.Oyuncunun Puanı : "+Birinci_Oyuncu_Puani
        if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
           ikinci_oyuncu_skor_text_6lik.text="2.Oyuncunun Puanı : "+Ikinci_Oyuncu_Puani
        }
        acilan_kart_kontrolu.clear()
        Images_Hide_6lik()
    }
    fun Images_Hide_6lik(){
        for(k in (0..35)){
            if(imageArray_Sayi_Dizisi[k]==0)
            {
                imageArray[k].visibility= View.INVISIBLE
            } else
            {
                imageArray[k].visibility= View.VISIBLE
            }

            if(imageArray_Kapali_Sayi_Dizisi[k]==0)
            {
                imageArray_Kapali[k].visibility= View.VISIBLE
            } else
            {
                imageArray_Kapali[k].visibility= View.INVISIBLE
            }
        }
    }
    fun Oyun_6lik_Ipucu(view:View)
    {
        Oyun_6lik_Ipucu_Image.visibility=View.INVISIBLE
        Oyun_6lik_Ipucu_Text.visibility=View.VISIBLE
        kalan_sure_text_6lik.visibility=View.INVISIBLE
        birinci_oyuncu_skor_text_6lik.visibility=View.INVISIBLE
        ikinci_oyuncu_skor_text_6lik.visibility=View.INVISIBLE
        Oyun_6lik_kapat_Image.visibility=View.VISIBLE
        acilan_kart_kontrolu.clear()
        for(k in (0..35)){
            imageArray[k].visibility= View.INVISIBLE
            imageArray_Kapali[k].visibility= View.INVISIBLE
        }
    }
    fun Oyun_6lik_Kapat(view:View)
    {
        Oyun_6lik_Ipucu_Image.visibility=View.VISIBLE
        Oyun_6lik_Ipucu_Text.visibility=View.INVISIBLE
        kalan_sure_text_6lik.visibility=View.VISIBLE
        birinci_oyuncu_skor_text_6lik.visibility=View.VISIBLE
        if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            ikinci_oyuncu_skor_text_6lik.visibility=View.VISIBLE
        }
        Oyun_6lik_kapat_Image.visibility=View.INVISIBLE
        Images_Hide_6lik()
    }
    fun Oyun_6lik_Geri_Image(view : View) {
        mediaplayer_oyun_boyunca_calan_muzik?.stop()
        mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
        mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
        mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
        val intent2= Intent(applicationContext,Giris_Yap_Menu::class.java)
        intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent2)
        finish()
    }
    fun Bas1_6lik(view: View)
    {
        Resim_Ac_Kapa(1)
    }
    fun Bas2_6lik(view: View)
    {
        Resim_Ac_Kapa(2)
    }
    fun Bas3_6lik(view: View)
    {
        Resim_Ac_Kapa(3)
    }
    fun Bas4_6lik(view: View)
    {
        Resim_Ac_Kapa(4)
    }
    fun Bas5_6lik(view: View)
    {
        Resim_Ac_Kapa(5)
    }
    fun Bas6_6lik(view: View)
    {
        Resim_Ac_Kapa(6)
    }
    fun Bas7_6lik(view: View)
    {
        Resim_Ac_Kapa(7)
    }
    fun Bas8_6lik(view: View)
    {
        Resim_Ac_Kapa(8)
    }
    fun Bas9_6lik(view: View)
    {
        Resim_Ac_Kapa(9)
    }
    fun Bas10_6lik(view: View)
    {
        Resim_Ac_Kapa(10)
    }
    fun Bas11_6lik(view: View)
    {
        Resim_Ac_Kapa(11)
    }
    fun Bas12_6lik(view: View)
    {
        Resim_Ac_Kapa(12)
    }
    fun Bas13_6lik(view: View)
    {
        Resim_Ac_Kapa(13)
    }
    fun Bas14_6lik(view: View)
    {
        Resim_Ac_Kapa(14)
    }
    fun Bas15_6lik(view: View)
    {
        Resim_Ac_Kapa(15)
    }
    fun Bas16_6lik(view: View)
    {
        Resim_Ac_Kapa(16)
    }
    fun Bas17_6lik(view: View)
    {
        Resim_Ac_Kapa(17)
    }
    fun Bas18_6lik(view: View)
    {
        Resim_Ac_Kapa(18)
    }
    fun Bas19_6lik(view: View)
    {
        Resim_Ac_Kapa(19)
    }
    fun Bas20_6lik(view: View)
    {
        Resim_Ac_Kapa(20)
    }
    fun Bas21_6lik(view: View)
    {
        Resim_Ac_Kapa(21)
    }
    fun Bas22_6lik(view: View)
    {
        Resim_Ac_Kapa(22)
    }
    fun Bas23_6lik(view: View)
    {
        Resim_Ac_Kapa(23)
    }
    fun Bas24_6lik(view: View)
    {
        Resim_Ac_Kapa(24)
    }
    fun Bas25_6lik(view: View)
    {
        Resim_Ac_Kapa(25)
    }
    fun Bas26_6lik(view: View)
    {
        Resim_Ac_Kapa(26)
    }
    fun Bas27_6lik(view: View)
    {
        Resim_Ac_Kapa(27)
    }
    fun Bas28_6lik(view: View)
    {
        Resim_Ac_Kapa(28)
    }
    fun Bas29_6lik(view: View)
    {
        Resim_Ac_Kapa(29)
    }
    fun Bas30_6lik(view: View)
    {
        Resim_Ac_Kapa(30)
    }
    fun Bas31_6lik(view: View)
    {
        Resim_Ac_Kapa(31)
    }
    fun Bas32_6lik(view: View)
    {
        Resim_Ac_Kapa(32)
    }
    fun Bas33_6lik(view: View)
    {
        Resim_Ac_Kapa(33)
    }
    fun Bas34_6lik(view: View)
    {
        Resim_Ac_Kapa(34)
    }
    fun Bas35_6lik(view: View)
    {
        Resim_Ac_Kapa(35)
    }
    fun Bas36_6lik(view: View)
    {
        Resim_Ac_Kapa(36)
    }
}