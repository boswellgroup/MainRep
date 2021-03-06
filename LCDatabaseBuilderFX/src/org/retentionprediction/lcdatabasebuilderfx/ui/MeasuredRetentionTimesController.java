package org.retentionprediction.lcdatabasebuilderfx.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

import org.retentionprediction.lcdatabasebuilderfx.business.Globals;
import org.retentionprediction.lcdatabasebuilderfx.business.GradientProgramStep;
import org.retentionprediction.lcdatabasebuilderfx.business.StandardCompound;

import boswell.peakfinderlcfx.PeakFinderLCFX;

public class MeasuredRetentionTimesController implements Initializable, ChangeListener<Boolean> {

	@FXML private Label finalSolventComposition;
    @FXML private Label holdTime;	//Useless
    @FXML private Label gradientTime;
    @FXML private Label labelColumnLength;
    @FXML private Label initialSolventComposition;
    @FXML private Label labelInstrumentDeadTime;
    @FXML private Label labelFlowRateUnits;
    @FXML private Label labelInnerDiameter;
	
	@FXML private ComboBox<String> comboStationaryPhase;
	
    @FXML private TableColumn<StandardCompound, Boolean> columnUse;
    @FXML private TableColumn<StandardCompound, String> columnRetentionTime;
    @FXML private TableColumn<StandardCompound, String> columnMZ;
    @FXML private TableColumn<StandardCompound, String> columnCompound;
    @FXML private TableView<GradientProgramStep> tableViewGradientProgram;
	@FXML private TableColumn<GradientProgramStep, Double> columnTime;
	@FXML private TableColumn<GradientProgramStep, Double> columnSolventComposition;
    
    @FXML private TextField textFieldColumnLength;
    @FXML private TextField textFieldFlowRate;
    @FXML private TextField textFieldInnerDiameter;
    @FXML private TextField textFieldInstrumentDeadTime;
    
    @FXML private TableView<StandardCompound> tableMeasuredRetentionTimes;
  
    @FXML private TitledPane requirementsPane;

    @FXML private ScrollPane measuredretentiontimespage;

    @FXML private Button buttonNextStep;

    private MeasuredRetentionTimesControllerListener measuredRetentionTimesControllerListener;
    private ObservableList<StandardCompound> standardsList;

    private double[][] gradientProgramInConventionalForm = {{0.0,5.0},{5.0,95.0}};
    
	private double columnLength = 100; // in mm
	private double innerDiameter = 2.1; // in mm
	private double instrumentDeadTime = 0.125; // in  min
	private double flowRate = 0.4; // in mL/min
	
	private Window parentWindow;
	private String fileName;
	private String strProgramName = "";
	private ObservableList<GradientProgramStep> gradientProgramList;
	private int index = -1;
	
	private boolean isInjectionGradientMode = false;
	
   	public interface MeasuredRetentionTimesControllerListener{
   		public void onNextStepPressed(MeasuredRetentionTimesController thisController);
    }
   	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable,
			Boolean oldValue, Boolean newValue) {
		if (newValue == false)
		{
			// Lost focus, so commit the text
			performValidations();
		}	
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboStationaryPhase.getItems().clear();
		comboStationaryPhase.getItems().addAll("Eclipse Plus C18");
		
		textFieldColumnLength.focusedProperty().addListener(this);
		textFieldInnerDiameter.focusedProperty().addListener(this);
		textFieldFlowRate.focusedProperty().addListener(this);
		textFieldInstrumentDeadTime.focusedProperty().addListener(this);
		
		
		List<StandardCompound> data = new ArrayList<StandardCompound>();
		for (int i = 0; i < Globals.StandardCompoundsNameArray.length; i++){
			StandardCompound newItem = new StandardCompound();
			newItem.setUse(false);
			newItem.setName(Globals.StandardCompoundsNameArray[i]);
			newItem.setMz(Globals.convertMZToString(Globals.StandardCompoundsMZArray[i]));
			newItem.setMeasuredRetentionTime(0.0);
			newItem.setIndex(i);
			data.add(newItem);
		}
		standardsList = FXCollections.observableArrayList(data);
		
		//Temporary code : Preload the table
		double[] dRetentionTimes = Globals.dPredefinedValues[0][0];
		boolean[] bSkippedStandards = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};	
		for (int i = 0; i < dRetentionTimes.length; i++)
		{
			// Mark whether the standard is skipped.
			standardsList.get(i).setUse(!bSkippedStandards[i]);
			if (!bSkippedStandards[i])
				standardsList.get(i).setMeasuredRetentionTime(dRetentionTimes[i]);
			else
				standardsList.get(i).setMeasuredRetentionTime(0.0);
		}
		
		performValidations();
		//End
		
		
		columnUse.setCellValueFactory(new PropertyValueFactory<StandardCompound,Boolean>("use"));
		columnUse.setCellFactory(new Callback<TableColumn<StandardCompound, Boolean>, TableCell<StandardCompound, Boolean>>() {
            public TableCell<StandardCompound, Boolean> call(TableColumn<StandardCompound, Boolean> p) 
            {
            	CheckBoxTableCell<StandardCompound, Boolean> cb = new CheckBoxTableCell<StandardCompound, Boolean>();
            	cb.setAlignment(Pos.CENTER);
                return cb;
            }
        });
		columnCompound.setCellValueFactory(new PropertyValueFactory<StandardCompound,String>("name"));
		columnMZ.setCellValueFactory(new PropertyValueFactory<StandardCompound,String>("mz"));
		
		columnRetentionTime.setCellValueFactory(new PropertyValueFactory<StandardCompound,String>("measuredRetentionTimeString"));
		columnRetentionTime.setCellFactory(TextFieldTableCell.<StandardCompound>forTableColumn());
		setTableMeasuredRetentionTimesItems(standardsList);
	
		//tableViewGradientProgram.setEditable(false);
		
		//Load the table with correct values
		List<GradientProgramStep> data1 = new ArrayList<GradientProgramStep>();
		gradientProgramList = FXCollections.observableArrayList(data1);
		setGradientProgramInConventionalForm();
		columnTime.setCellValueFactory(new PropertyValueFactory<GradientProgramStep, Double>("time"));
		columnTime.setCellFactory(TextFieldTableCell.<GradientProgramStep, Double>forTableColumn(new DoubleStringConverter()));
		columnSolventComposition.setCellValueFactory(new PropertyValueFactory<GradientProgramStep, Double>("solventComposition"));
		columnSolventComposition.setCellFactory(TextFieldTableCell.<GradientProgramStep, Double>forTableColumn(new DoubleStringConverter()));
		this.tableViewGradientProgram.setItems(gradientProgramList);
	}
	
	private void setTableMeasuredRetentionTimesItems(ObservableList<StandardCompound> standardCompoundList){
		standardsList = standardCompoundList;
		
		tableMeasuredRetentionTimes.setItems(standardsList);
		
		// Add a listener for the "Use" property
		for (int i = 0; i < standardsList.size(); i++){
			StandardCompound thisStandard = standardsList.get(i);
			
			thisStandard.useProperty().addListener(new ChangeListener<Boolean>(){
						@Override
						public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
							performValidations();
						}
					});
		}
		performValidations();
	}
	
	public void performValidations()
	{
		columnLength = validatePhysicalVariables(textFieldColumnLength, 0.1, 10000);
		innerDiameter = validatePhysicalVariables(textFieldInnerDiameter, 0.00001, 10000);
		flowRate = validatePhysicalVariables(textFieldFlowRate, 0.000000001, 10000);
		instrumentDeadTime = validatePhysicalVariables(textFieldInstrumentDeadTime, 0.0, 100);
		
		// Now check to see if we have enough retention times to make the Next Step button enabled
		int iTotalUsed = 0;
		for (int i = 0; i < this.standardsList.size(); i++)
		{
			if (standardsList.get(i).getUse())
				iTotalUsed++;
		}
		
		if (iTotalUsed >= 8)
			buttonNextStep.setDisable(false);
		else
			buttonNextStep.setDisable(true);			
	}
	
	private double validatePhysicalVariables(TextField textField, double dTempLow, double dTempHigh){
		double dTemp = 0;
    	try
    	{
    		dTemp = (double)Float.valueOf(textField.getText());
    	}
    	catch (NumberFormatException e)
    	{
    		dTemp = 0.0;
    	}
		
		if (dTemp < dTempLow)
			dTemp = dTempLow;
		if (dTemp > dTempHigh)
			dTemp = dTempHigh;
		
		textField.setText(Float.toString((float)dTemp));   
		return dTemp;
	}
	
	/**
	 * Sets the text fields for the stationary phase variables to the values that are stored in this class for those variables.
	 * You would need this method if values such as columnLength,flowRate,etc are changed in the backend but the user is only seeing
	 * values on the User Interface that he set in the first place.
	 */
	public void setTextFieldsByStationaryPhaseVars(){
		textFieldColumnLength.setText(String.valueOf(columnLength));
		textFieldFlowRate.setText(String.valueOf(flowRate));
		textFieldInnerDiameter.setText(String.valueOf(innerDiameter));
		textFieldInstrumentDeadTime.setText(String.valueOf(instrumentDeadTime));
		performValidations();
	}
	
	@FXML private void commitRetentionTime(TableColumn.CellEditEvent<StandardCompound,String> t)
	{
		Double dNewRetentionTime = 0.0;
		try
		{
			dNewRetentionTime = Double.valueOf(t.getNewValue());
		}
		catch (NumberFormatException e)
		{
			dNewRetentionTime = 0.0;
		}
		
		// Get the current item that was changed
		StandardCompound currentItem = (StandardCompound)t.getTableView().getItems().get(t.getTablePosition().getRow());

		// Commit the new retention time
		currentItem.setMeasuredRetentionTime(dNewRetentionTime);

		// Check to see if the new retention time is <> 0. If so, check the corresponding box.
		if (dNewRetentionTime > 0)
			currentItem.setUse(true);
		else
			currentItem.setUse(false);
			
		performValidations();
	}
	
	@FXML private void actionPerformValidation(ActionEvent e){
		performValidations();
	}
	
	@FXML private void onNextStepAction(ActionEvent e){
		// Send notification back to the ParentPaneController to change the visible pane
		if (measuredRetentionTimesControllerListener != null)
			this.measuredRetentionTimesControllerListener.onNextStepPressed(this);
	}
	
	@FXML private void onFindRetentionTimesAutomatically(ActionEvent e){
		PeakFinderLCFX peakfinder = new PeakFinderLCFX(parentWindow, Globals.StationaryPhaseArray, true);
		peakfinder.setStandardCompoundMZData(Globals.StandardCompoundsMZArray);
		peakfinder.setStandardCompoundNames(Globals.StandardCompoundsNameArray);
		peakfinder.setIsocraticDataArray(Globals.StandardIsocraticDataArray);
		peakfinder.setFileName(fileName);
		peakfinder.setColumnLength(columnLength);
		peakfinder.setFlowRate(flowRate);
		peakfinder.setInstrumentDeadTime(instrumentDeadTime);
		
		gradientProgramInConventionalForm = getGradientProgram();
		
		peakfinder.setGradientProgramInConventionalForm(gradientProgramInConventionalForm);
		peakfinder.setInnerDiameter(innerDiameter);
		peakfinder.setInterpolatedDeadTime(null);
		peakfinder.run();
		
		if (peakfinder.getOkPressed())
    	{
    		double[] dRetentionTimes = peakfinder.getSelectedRetentionTimes();
    		boolean[] bSkippedStandards = peakfinder.getSkippedStandards();
    		int[] iPeakRank = peakfinder.getSelectedPeakRank();
		
    		for (int i = 0; i < dRetentionTimes.length; i++)
    		{
    			// Mark whether the standard is skipped.
    			standardsList.get(i).setUse(!bSkippedStandards[i]);
    			
    			// Put in the correct retention time
    			if (iPeakRank[i] >= 0)
    			{
    				if (!bSkippedStandards[i])
    					standardsList.get(i).setMeasuredRetentionTime(dRetentionTimes[i]);
    				else
    					standardsList.get(i).setMeasuredRetentionTime(0.0);
    			}
    			else
    			{
					standardsList.get(i).setMeasuredRetentionTime(0.0);    				
	    			standardsList.get(i).setUse(false);
    			}
    		}
    		
    		fileName = peakfinder.getFileName();
    		performValidations();
    	}
	}

	public void writeSaveData(SaveData.MeasuredRetentionTimeSaveData saveData)
	{
		saveData.programName = strProgramName;
		saveData.fileName = fileName;
		saveData.standardsList = standardsList;
		saveData.columnLength = columnLength;
		saveData.innerDiameter = innerDiameter;
		saveData.flowRate = flowRate;
		saveData.instrumentDeadTime = instrumentDeadTime;
	}
	
	public void writeSaveData(InjectionSaveData.MeasuredRetentionTimeSaveData saveData)
	{
		saveData.programName = strProgramName;
		saveData.fileName = fileName;
		saveData.standardsList = standardsList;
		saveData.columnLength = columnLength;
		saveData.innerDiameter = innerDiameter;
		saveData.flowRate = flowRate;
		saveData.instrumentDeadTime = instrumentDeadTime;
	}
	
	public void loadSaveData(SaveData.MeasuredRetentionTimeSaveData saveData)
	{
		strProgramName = saveData.programName;
		fileName = saveData.fileName;
		standardsList = saveData.standardsList;
		columnLength = saveData.columnLength;
		innerDiameter = saveData.innerDiameter;
		flowRate = saveData.flowRate;
		instrumentDeadTime = saveData.instrumentDeadTime;
		gradientProgramInConventionalForm = saveData.gradientProgramInConventionalForm;
		setGradientProgramInConventionalForm();
		this.textFieldColumnLength.setText(Float.toString((float)columnLength));
		this.textFieldInnerDiameter.setText(Float.toString((float)innerDiameter));
		this.textFieldFlowRate.setText(Float.toString((float)flowRate));
		this.setProgramName(strProgramName);
		setTableMeasuredRetentionTimesItems(standardsList);
	}
	
	public void loadSaveData(InjectionSaveData.MeasuredRetentionTimeSaveData saveData)
	{
		strProgramName = saveData.programName;
		fileName = saveData.fileName;
		standardsList = saveData.standardsList;
		columnLength = saveData.columnLength;
		innerDiameter = saveData.innerDiameter;
		flowRate = saveData.flowRate;
		instrumentDeadTime = saveData.instrumentDeadTime;
		gradientProgramInConventionalForm = saveData.gradientProgramInConventionalForm;
		setGradientProgramInConventionalForm();
		this.textFieldColumnLength.setText(Float.toString((float)columnLength));
		this.textFieldInnerDiameter.setText(Float.toString((float)innerDiameter));
		this.textFieldFlowRate.setText(Float.toString((float)flowRate));
		this.setProgramName(strProgramName);
		setTableMeasuredRetentionTimesItems(standardsList);
	}
	
	public void setParentWindow(Window parentWindow)
	{
		this.parentWindow = parentWindow;
	}
	
	public void setGradientProgramInConventionalForm() {
		
		gradientProgramList.clear();
		for(int i = 0; i < gradientProgramInConventionalForm.length; i++){
			GradientProgramStep step = new GradientProgramStep(gradientProgramInConventionalForm[i][0], gradientProgramInConventionalForm[i][1]);
			gradientProgramList.add(step);
		}
	}
	
	public void setGradientProgramInConventionalForm(double[][] gradientProgramInConventionalForm){
		this.gradientProgramInConventionalForm = gradientProgramInConventionalForm;
		setGradientProgramInConventionalForm();
	}
	
	public double[][] getGradientProgram() {
		double[][] gradientProgramInConventionalForm = new double[gradientProgramList.size()][2];
		for (int i = 0; i < gradientProgramList.size(); i++)
		{
			gradientProgramInConventionalForm[i][0] = gradientProgramList.get(i).getTime();
			gradientProgramInConventionalForm[i][1] = gradientProgramList.get(i).getSolventComposition();
		}
		
		//return Globals.convertGradientProgramInConventionalFormToRegularForm(gradientProgramInConventionalForm, initialTime, initialSolventComp);
		return gradientProgramInConventionalForm;
	}
	
	public MeasuredRetentionTimesControllerListener getMeasuredRetentionTimesControllerListener() {
		return measuredRetentionTimesControllerListener;
	}

	public void setMeasuredRetentionTimesControllerListener(
			MeasuredRetentionTimesControllerListener measuredRetentionTimesControllerListener) {
		this.measuredRetentionTimesControllerListener = measuredRetentionTimesControllerListener;
	}
	
	public ObservableList<StandardCompound> getStandardsList() {
		return standardsList;
	}

	public void setStandardsList(ObservableList<StandardCompound> standardsList) {
		this.standardsList = standardsList;
	}

	public double getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(double columnLength) {
		this.columnLength = columnLength;
	}

	public double getInstrumentDeadTime() {
		return instrumentDeadTime;
	}

	public void setInstrumentDeadTime(double instrumentDeadTime) {
		this.instrumentDeadTime = instrumentDeadTime;
	}

	public double getInnerDiameter() {
		return innerDiameter;
	}

	public void setInnerDiameter(double innerDiameter) {
		this.innerDiameter = innerDiameter;
	}

	public double getFlowRate() {
		return flowRate;
	}

	public void setFlowRate(double flowRate) {
		this.flowRate = flowRate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public TextField getTextFieldColumnLength() {
		return textFieldColumnLength;
	}

	public void setTextFieldColumnLength(TextField textFieldColumnLength) {
		this.textFieldColumnLength = textFieldColumnLength;
	}

	public TextField getTextFieldFlowRate() {
		return textFieldFlowRate;
	}

	public void setTextFieldFlowRate(TextField textFieldFlowRate) {
		this.textFieldFlowRate = textFieldFlowRate;
	}

	public TextField getTextFieldInnerDiameter() {
		return textFieldInnerDiameter;
	}

	public void setTextFieldInnerDiameter(TextField textFieldInnerDiameter) {
		this.textFieldInnerDiameter = textFieldInnerDiameter;
	}

	public TextField getTextFieldInstrumentDeadTime() {
		return textFieldInstrumentDeadTime;
	}

	public void setTextFieldInstrumentDeadTime(TextField textFieldInstrumentDeadTime) {
		this.textFieldInstrumentDeadTime = textFieldInstrumentDeadTime;
	}

	public void setProgramName(String strName)
	{
		strProgramName = strName;
		requirementsPane.setText("Requirements for " + strProgramName);
	}

	//TODO: delete this method later
	public void setIndex(int index) {
		this.index  = index;
		double[] dRetentionTimes = Globals.dPredefinedValues[0][index];
		boolean[] bSkippedStandards = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};	
		for (int i = 0; i < dRetentionTimes.length; i++)
		{
			// Mark whether the standard is skipped.
			standardsList.get(i).setUse(!bSkippedStandards[i]);
			if (!bSkippedStandards[i])
				standardsList.get(i).setMeasuredRetentionTime(dRetentionTimes[i]);
			else
				standardsList.get(i).setMeasuredRetentionTime(0.0);
		}
	}

	public boolean isInjectionGradientMode() {
		return isInjectionGradientMode;
	}

	public void setInjectionGradientMode(boolean isInjectionGradientMode) {
		this.isInjectionGradientMode = isInjectionGradientMode;
		if(isInjectionGradientMode){
			gradientProgramInConventionalForm[1][0] = 60.0;
		}
		else{
			gradientProgramInConventionalForm[1][0] = 5.0;
		}
		setGradientProgramInConventionalForm();
		tableViewGradientProgram.setEditable(false);
	}

	public String copyProfileToClipboard() {
    	// Make a string that can be pasted into Excel
    	String outString = "";
    	String eol = System.getProperty("line.separator");
    	// First create the heading
    	// Programmed conditions
    	outString += "Programmed (initial) experimental conditions" + eol;
    	int selectedStationaryPhaseIndex = comboStationaryPhase.getSelectionModel().getSelectedIndex() > -1 ? comboStationaryPhase.getSelectionModel().getSelectedIndex() : 0;
    	outString += "Stationary phase:\t" + Globals.StationaryPhaseArray[selectedStationaryPhaseIndex] + eol;
    	outString += "Column inner diameter:\t" + textFieldInnerDiameter.getText() + "\tmm" + eol;
    	outString += "Column length:\t" + textFieldColumnLength.getText() + "\tmm" + eol;
    	outString += "Flow rate:\t" + textFieldFlowRate.getText() + "\tmL/min" + eol;
    	outString += "Instrument dead time:\t" + textFieldInstrumentDeadTime.getText() + "\tmin" + eol;
    	outString += "Gradient program:" + eol;
    	outString += "Time (min)\tEluent composition (%B)" + eol;
    	double[][] gradientProgram = getGradientProgram();
    	for (int i = 0; i < gradientProgram.length; i++)
    	{
    		outString += gradientProgram[i][0] + "\t" + gradientProgram[i][1] + eol;
    	}
    	outString += eol;
        
		return outString;
	}
	
	public Map<String,String> exportToXml() {
    	Map<String,String> map = new HashMap<String,String>();
		int selectedStationaryPhaseIndex = comboStationaryPhase.getSelectionModel().getSelectedIndex() > -1 ? comboStationaryPhase.getSelectionModel().getSelectedIndex() : 0;
    	map.put("StationaryPhase", Globals.StationaryPhaseArray[selectedStationaryPhaseIndex]);
    	map.put("ColumnInnerDiameter", textFieldInnerDiameter.getText());
    	map.put("ColumnLength", textFieldColumnLength.getText());
    	map.put("FlowRate", textFieldFlowRate.getText());
    	map.put("InstrumentDeadTime", textFieldInstrumentDeadTime.getText());
    	
    	double[][] gradientProgram = getGradientProgram();
    	for (int i = 0; i < gradientProgram.length; i++)
    	{
    		if(map.containsKey("GradientTimes")){
    			map.put("GradientTimes", map.get("GradientTimes")+"$"+gradientProgram[i][0]);
    		}
    		else{
    			map.put("GradientTimes", gradientProgram[i][0]+"");
    		}
    		if(map.containsKey("GradientSolventCompositions")){
    			map.put("GradientSolventCompositions", map.get("GradientSolventCompositions")+"$"+gradientProgram[i][1]);
    		}
    		else{
    			map.put("GradientSolventCompositions", gradientProgram[i][1]+"");
    		}
    	}
		return map;
	}

}
