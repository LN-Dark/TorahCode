package com.lua.torahcode.ui.codefinder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.lua.torahcode.DelayedProgressDialog;
import com.lua.torahcode.R;
import com.lua.torahcode.TorahBible;

public class CodeFinderFragment extends Fragment {
    private View root;
    private TorahBible Torahbible = new TorahBible();
    private final DelayedProgressDialog progressDialog = new DelayedProgressDialog();
    private int numerodevoltas = 0;
    private String pontodepartidainicial = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_codefinder, container, false);
        final MaterialButton comecarBTN = root.findViewById(R.id.btn_procurar_letras);
        final MaterialButton LimparBTN = root.findViewById(R.id.btn_limpar);
        final TextView textoConvertido = root.findViewById(R.id.txt_palavrasencontradas);
        final TextInputEditText textoaProcurar = root.findViewById(R.id.txt_escreveo_texto_procurar_procurar);

        comecarBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setCancelable(false);
                progressDialog.show(getChildFragmentManager(), "tag");
                comecarBTN.setEnabled(false);
                LimparBTN.setEnabled(false);
                final TextInputEditText pontodePartida = root.findViewById(R.id.txt_pontodepartida_partida);
                pontodepartidainicial = pontodePartida.getText().toString();
                String resultado = ProcuraPalavra();
                String textoProcurar = textoaProcurar.getText().toString();
                if(!textoProcurar.isEmpty()){
                    numerodevoltas = 0;

                    while (!resultado.equals(textoProcurar)) {
                        progressDialog.show(getChildFragmentManager(), "tag");
                        resultado = ProcuraPalavra();
                        if(numerodevoltas >= 304805){
                            pontodePartida.setText(pontodepartidainicial);
                            Toast.makeText(root.getContext(), "Nao foram encontrados resultados!", Toast.LENGTH_LONG).show();
                            comecarBTN.setEnabled(true);
                            LimparBTN.setEnabled(true);
                            break;
                        }
                    }
                    if(resultado.equals(textoProcurar)){
                        textoConvertido.setText(textoConvertido.getText().toString()  + "\n\n" + resultado);
                    }
                    progressDialog.cancel();
                }else {
                    textoConvertido.setText(textoConvertido.getText().toString()  + "\n\n" + resultado);
                    comecarBTN.setEnabled(true);
                    LimparBTN.setEnabled(true);
                    progressDialog.cancel();
                }
            }
        });
        LimparBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextInputEditText pontodePartida = root.findViewById(R.id.txt_pontodepartida_partida);
                final TextInputEditText skipNumber = root.findViewById(R.id.txt_avanco_avanco);
                final TextInputEditText numeromaximoCaracteres = root.findViewById(R.id.txt_numeromaximocaracteres_maximo);
                textoaProcurar.setText("");
                textoConvertido.setText("");
                pontodePartida.setText("");
                skipNumber.setText("");
                numeromaximoCaracteres.setText("");
            }
        });
        return root;
    }

    private String ProcuraPalavra(){
        StringBuilder resultado = new StringBuilder();
        String torahCompleto = Torahbible.getFullTorah();
        final TextInputEditText pontodePartida = root.findViewById(R.id.txt_pontodepartida_partida);
        final TextInputEditText skipNumber = root.findViewById(R.id.txt_avanco_avanco);
        final TextInputEditText numeromaximoCaracteres = root.findViewById(R.id.txt_numeromaximocaracteres_maximo);
        int skipnumero = Integer.parseInt(skipNumber.getText().toString());
        int maximo = Integer.parseInt(numeromaximoCaracteres.getText().toString());
        int partida = Integer.parseInt(pontodePartida.getText().toString());
        torahCompleto = torahCompleto.replaceAll("[^א-יכ-למנ-עפצ-רת]", "");
        for(int i = partida ; i < torahCompleto.length(); i++){
            resultado.append(torahCompleto.charAt(i));
            i += skipnumero -1;
            numerodevoltas += i;
            if(resultado.length() ==  maximo){
                break;
            }
        }
        int resultavancos = skipnumero * maximo + partida;
        pontodePartida.setText(String.valueOf(resultavancos));
        return resultado.toString();
    }
}
