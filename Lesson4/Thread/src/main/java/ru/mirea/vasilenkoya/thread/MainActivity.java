package ru.mirea.vasilenkoya.thread;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import ru.mirea.vasilenkoya.thread.databinding.ActivityMainBinding;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Handler handler = new Handler();
         Thread currentThread = Thread.currentThread();
         binding.TextView.setText("Имя текущего потока: " + currentThread.getName());
         currentThread.setName("Мой номер группы: БСБО-06-22, Мой номер по списку: 3, Мой любимый фильм: Гарри Поттер");
         binding.TextView.append("\nНовое имя потока: " + currentThread.getName());
         Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(currentThread.getStackTrace()));

         binding.buttonn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         int numberThread = counter++;
                         Log.d("ThreadProject", String.format("Запущен поток №%d студентом " +
                                 "группы №%s номер по списку №%d", numberThread, "БСБО-06-22", 3));

                         handler.post(new Runnable() {
                             @Override
                             public void run() {
                                 int lessons = Integer.parseInt(binding.Lessons.getText().toString());
                                 int days = Integer.parseInt(binding.Days.getText().toString());
                                 float average = (float) lessons / days;
                                 binding.textView2.setText("Среднее количество пар в день = " + average);
                             }
                         });
                         long endTime = System.currentTimeMillis() + 20*1000;
                         while (System.currentTimeMillis() < endTime){
                             synchronized (this){
                                 try{
                                     wait(endTime-System.currentTimeMillis());
                                 }catch (Exception e){
                                     throw new RuntimeException();
                                 }
                             }
                             Log.d("ThreadProject", "Выполнен поток №	"	+	numberThread);
                         }
                        }
                    }).start();

                }
            });
        }
    }