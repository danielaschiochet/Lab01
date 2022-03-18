package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtPerformance;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	String parola = txtParola.getText();
    	
    	double tempoEsecuzioneStart = System.nanoTime();
    	
    	elenco.addParola(parola);
    	
    	double tempoEsecuzioneEnd = System.nanoTime();
    	
    	this.txtParola.clear();
    	this.txtResult.clear();
    	this.txtPerformance.clear();
    	
    	String result="";
    	
    	for(String s: elenco.getElenco()) {
    		result = result + s + "\n";
    	}
    	
    	this.txtResult.setText(result);
    	this.txtPerformance.setText("Tempo impiegato: "+(tempoEsecuzioneEnd - tempoEsecuzioneStart)/1e9+" secondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	this.txtParola.clear();
    	this.txtResult.clear();
    	this.txtPerformance.clear();
    	double tempoEsecuzioneStart = System.nanoTime();
    	this.elenco.reset();
    	double tempoEsecuzioneEnd = System.nanoTime();
    	this.txtPerformance.setText("Tempo impiegato: "+(tempoEsecuzioneEnd - tempoEsecuzioneStart)/1e9+" secondi");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String parolaDaRimuovere = txtResult.getSelectedText();
    	
    	double tempoEsecuzioneStart = System.nanoTime();
    	
    	this.elenco.cancella(parolaDaRimuovere);
    	
    	double tempoEsecuzioneEnd = System.nanoTime();
    	
    	this.txtParola.clear();
    	this.txtResult.clear();
    	this.txtPerformance.clear();
    	
    	String result = "";
    	
    	for(String s: elenco.getElenco()) {
    		result = result + s + "\n";
    	}
    	
    	this.txtResult.setText(result);
    	this.txtPerformance.setText("Tempo impiegato: "+(tempoEsecuzioneEnd - tempoEsecuzioneStart)/1e9+" secondi");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}