package com.example.ifpr.tccdaalana;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bancodedados.DBController;

public class SentimentoActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentimento);
    }

    public void euTeAmo (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.te_amo);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "TeAmo");

    }
    public void euEstouFeliz (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_feliz);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Feliz");


    }
    public void euEstouTriste (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_triste);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Triste");
    }
    public void euEstouComRaiva (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_com_raiva);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Raiva");

    }
    public void euEstouComMedo (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_com_medo);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Medo");

    }
    public void euEstouDesapontado (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_desapontado);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Desapontado");

    }
    public void euEstouChorando (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_chorando);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Chorando");
    }
    public void euEstouComCalor (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_com_calor);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Calor");

    }
    public void euEstouSemPalavras (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_sem_palavras);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "SemPalavras");

    }
    public void euEstouComSono (View v) throws IOException {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.estou_com_sono);
        mediaPlayer.start();
        RelatorioHelper.geraRelatorio(this, "Sono");

    }
    
    public void TelaSentimentosComida(View v){
        Intent intent = new Intent(this, ComidaActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosCasa(View v){
        Intent intent = new Intent(this,CasaActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosComunicacao(View v){
        Intent intent = new Intent(this, ComunicaçãoActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosCorpo(View v){
        Intent intent = new Intent(this, CorpoActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosDiversao(View v){
        Intent intent = new Intent(this,DiversaoActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosDor(View v){
        Intent intent = new Intent(this,DorActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosEscola(View v){
        Intent intent = new Intent(this,EscolaActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosFamilia(View v){
        Intent intent = new Intent(this,FamiliaActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosLetras(View v){
        Intent intent = new Intent(this,LetrasActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosNumeros(View v){
        Intent intent = new Intent(this,NumerosActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosNecessidades(View v){
        Intent intent = new Intent(this, NecessidadeActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosPablavrasBasicas(View v){
        Intent intent = new Intent(this,PalavrasBasicasActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosRoupas(View v){
        Intent intent = new Intent(this, RoupasActivity.class);
        startActivity(intent);
    }
    public void TelaSentimentosSentidos(View v){
        Intent intent = new Intent(this,SentidosActivity.class);
        startActivity(intent);
    }
    
    public void voltarSentimentos (View view){
        Intent intent = new Intent(this, PerfilFilhoActivity.class);
        startActivity(intent);
    }
}
