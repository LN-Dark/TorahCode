package com.lua.torahcode.ui.basico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.lua.torahcode.DicionarioIngles;
import com.lua.torahcode.HebrewAlphabet;
import com.lua.torahcode.R;
import com.lua.torahcode.TorahBible;

import java.util.ArrayList;

public class BasicoFragment extends Fragment {
    private View root;
    private String textosemnonalpha = "";
    private DicionarioIngles DicionarioinglesClass = new DicionarioIngles();
    private HebrewAlphabet Alfabetohebraico = new HebrewAlphabet();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_basico, container, false);
        MaterialButton contarPalavrasDicionario = root.findViewById(R.id.btn_contarpalavras_dicionario);
        final TextInputEditText textotoTrasnlate = root.findViewById(R.id.txt_escreveo_texto_texto);
        MaterialButton contarPalavrasTexto = root.findViewById(R.id.btn_contarpalavras_Texto);
        MaterialButton Converterhebraico = root.findViewById(R.id.btn_converter_hebrew);
        MaterialButton ConverterLetrasNormais = root.findViewById(R.id.btn_converter_letrasComuns);
        final TextView textoConvertido = root.findViewById(R.id.txt_textoconvertido);
        contarPalavrasDicionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> dicionario;
                dicionario = DicionarioinglesClass.getArraylistOfDicionario();
               Toast.makeText(getContext(), "O dicionario tem: " + dicionario.size() + " palavras.", Toast.LENGTH_LONG).show();

            }
        });
        contarPalavrasTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textosemnonalpha = textotoTrasnlate.getText().toString().replaceAll("[^a-zA-Z0-9]", "");
                textosemnonalpha = textosemnonalpha.toLowerCase();
                Toast.makeText(getContext(), "O texto tem: " + textosemnonalpha.length() + " caracteres.", Toast.LENGTH_LONG).show();
            }
        });
        Converterhebraico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder TextoConvertido = new StringBuilder();
                textosemnonalpha = textotoTrasnlate.getText().toString().replaceAll("[^a-zA-Z0-9]", "");
                textosemnonalpha = textosemnonalpha.toLowerCase();
                for(int i = 0 ; i < textosemnonalpha.length(); i++){
                    String caracterconvertido = String.valueOf(Alfabetohebraico.ConvertToHebrew(textosemnonalpha.charAt(i)));
                    if(!caracterconvertido.equals(String.valueOf(textosemnonalpha.charAt(i)))){
                        TextoConvertido.append(Alfabetohebraico.ConvertToHebrew(textosemnonalpha.charAt(i)));
                    }
                }
                textoConvertido.setText(TextoConvertido.toString());
            }
        });
        ConverterLetrasNormais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder TextoConvertido = new StringBuilder();
                textosemnonalpha = textotoTrasnlate.getText().toString();
                for(int i = 0 ; i < textosemnonalpha.length(); i++){
                    String caracterconvertido = String.valueOf(Alfabetohebraico.ConvertToLetters(textosemnonalpha.charAt(i)));
                    if(!caracterconvertido.equals(String.valueOf(textosemnonalpha.charAt(i)))){
                        TextoConvertido.append(Alfabetohebraico.ConvertToLetters(textosemnonalpha.charAt(i)));
                    }
                }
                textoConvertido.setText(TextoConvertido.toString());
            }
        });
        return root;
    }
}
