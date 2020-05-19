package com.example.scientificcalculator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.scientificcalculator.R;
import com.example.scientificcalculator.controller.ArrayController;
import com.example.scientificcalculator.controller.ListArray;
import com.example.scientificcalculator.recyclerView.MyAdapter;
import com.example.scientificcalculator.storage.FirestoreController;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ScientificCalculatorActivity extends AppCompatActivity {
    ArrayList<ArrayController> mArrayList;
    private MyAdapter mAdapter;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_openbrac, btn_closebrac, btn_percentage, btn_dot, btn_equal, btn_clear;
    ImageButton btn_spaceClear;
    Button btn_addition, btn_subtraction, btn_multiply, btn_division, btn_power, btn_root, btn_sin, btn_cos, btn_tan, btn_log, btn_in, btn_history;
    TextView input_view;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        buildRecyclerView();
        input_view = findViewById(R.id.input1);
        btn_history = findViewById(R.id.History);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_0 = findViewById(R.id.btn_0);
        btn_sin = findViewById(R.id.btn_sin);
        btn_cos = findViewById(R.id.btn_cos);
        btn_tan = findViewById(R.id.btn_tan);
        btn_dot = findViewById(R.id.btn_dot);
        btn_addition = findViewById(R.id.btn_plus);
        btn_subtraction = findViewById(R.id.btn_subtract);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_division = findViewById(R.id.btn_divide);
        btn_power = findViewById(R.id.btn_power);
        btn_log = findViewById(R.id.logfunction);
        btn_in = findViewById(R.id.btn_In);
        btn_openbrac = findViewById(R.id.btn_openbrac);
        btn_percentage = findViewById(R.id.btn_percentage);
        btn_equal = findViewById(R.id.btn_result);
        btn_clear = findViewById(R.id.btn_clear);
        btn_spaceClear = findViewById(R.id.btn_delete);
        btn_closebrac = findViewById(R.id.btn_closebrac);
        btn_root = findViewById(R.id.btn_root);



        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_view.setText("");
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s0", process));
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s1", process));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s2", process));
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s3", process));
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s4", process));
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s5", process));
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s6", process));
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s7", process));
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s8", process));
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s9", process));
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%slog", process));
            }
        });
        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s+", process));
            }
        })
        ;
        btn_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s-", process));
            }
        })
        ;
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%sx", process));
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s/", process));
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s.", process));
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%ssin", process));
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%scos", process));
            }
        });

        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%stan", process));
            }
        });

        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%sIn", process));
            }
        });
        btn_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s√", process));
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s∛", process));
            }
        });

        btn_openbrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s(", process));
            }
        });
        btn_closebrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s)", process));
            }
        });
        btn_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                input_view.setText(String.format("%s%%", process));
            }
        });



        btn_spaceClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();
                if (process.length() > 0) {
                    process = process.substring(0, process.length() - 1);
                    input_view.setText(process);
                } else {
                    input_view.setText("");
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input_view.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("sin", "Math.sin");
                process = process.replaceAll("cos", "Math.cos");
                process = process.replaceAll("tan", "Math.tan");
                process = process.replaceAll("√", "Math.sqrt");
                process = process.replaceAll("log", "Math.log10");
                process = process.replaceAll("In", "Math.log");
                process = process.replaceAll("∛", "Math.cbrt");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";

                try {
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, process, "JavaScript", 1, null).toString();
                } catch (Exception e) {
                    result = "Error";
                }
                String resultString = new StringBuilder().append(process).append(" = ").append(result).toString();
                input_view.setText(resultString);
                mArrayList.add(new ArrayController(resultString));
                FirestoreController fc = new FirestoreController();
                fc.saveToFirebase(resultString);
                saveData();

            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mArrayList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new
                TypeToken<ArrayList<ArrayController>>() {
                }.getType();
        mArrayList = gson.fromJson(json, type);
        if (mArrayList == null) {
            mArrayList = new ArrayList<>();
        }
    }
    public void nextActivity(){
        Intent intent = new Intent(this, HistoryOfCalculation.class);
        startActivity(intent);
    }


    private void buildRecyclerView() {
        try {
            RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
            mRecyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(mArrayList);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        } catch (NullPointerException ignored) {

        }


    }
}
