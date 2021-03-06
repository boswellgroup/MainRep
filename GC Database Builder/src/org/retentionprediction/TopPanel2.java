package org.retentionprediction;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;

import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.retentionprediction.TopPanel.SpecialTableModel;
import org.retentionprediction.TopPanel.TableCellEditorCustom;

import boswell.graphcontrol.GraphControl;

import java.awt.GridBagConstraints;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.awt.GridLayout;

public class TopPanel2 extends JPanel implements TableModelListener, Scrollable, ComponentListener
{
	private static final long serialVersionUID = 1L;
	public JButton jbtnNextStep = null;
	public JButton jbtnPreviousStep = null;
	public JPanel jpanelGradientProfile = null;
	public GraphControl m_GraphControlTemp = null;
	public JPanel jpanelFlowProfile = null;
	public GraphControl m_GraphControlHoldUp = null;
	public GLCapabilities caps2 = null;
	public JPanel jpanelStep4 = null;
	public JScrollPane jScrollPane = null;
	public JTable jtableOutput = null;
	public JButton jbtnCalculate = null;
	public NoEditTableModel tmOutputModel = null;
	public JLabel jlblIterationNumber = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	public JLabel jlblVariance = null;
	public JLabel jlblPhase = null;
	public JLabel jlblTimeElapsed = null;
	private JLabel jLabel12 = null;
	public JLabel jlblLastVariance = null;
	private JLabel jLabel121 = null;
	public JLabel jlblPercentImprovement = null;
	public JButton jbtnHelp = null;
	public JProgressBar jProgressBar = null;
	private JLabel jLabel1111 = null;
	public JPanel jpanelStep6 = null;
	public JScrollPane jScrollPane1 = null;
	public JTable jtablePredictions = null;
	public JProgressBar jProgressBar2 = null;
	public JButton jbtnPredict = null;
	private JLabel jLabel11111 = null;
	public NoEditTableModel tmPredictionModel = null;
	public TestCompoundsTableModel m_tmTestCompoundsModel = null;
	public JPanel jpanelStep5 = null;
	private JScrollPane jScrollPane2 = null;
	public JTable jtableTestCompoundPredictions = null;
	public JButton jbtnAutomaticDetermineTestCompounds = null;
	public JLabel jlblStandardDeviation = null;
	private JLabel jlblStandardDeviationName = null;
	public SliderIndicator jSliderIndicator = null;
	private JLabel jlblGood = null;
	private JLabel jlblBad = null;
	public JLabel jlblInstructions = null;
	private JLabel jlblExpectedStandardDeviationName = null;
	public JLabel jlblExpectedStandardDeviation = null;
	private JLabel jlblColumnRatingName = null;
	public JLabel jlblColumnRating = null;
	private JLabel jlblToleranceWindow = null;
	public JTextField jtxtWindowConfidence = null;
	private JLabel jlblPercent = null;
	private JLabel jlblBackcalculatedTemperatureProgram = null;
	private JLabel jlblBackcalculatedHoldUpTime = null;
	/**
	 * This is the default constructor
	 */
	public TopPanel2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jlblBackcalculatedHoldUpTime = new JLabel();
		jlblBackcalculatedHoldUpTime.setBounds(new Rectangle(12, 284, 461, 16));
		jlblBackcalculatedHoldUpTime.setForeground(new Color(51, 51, 51));
		jlblBackcalculatedHoldUpTime.setText("Back-Calculated Hold-Up Time vs. Temperature Profile");
		jlblBackcalculatedHoldUpTime.setFont(new Font("Dialog", Font.BOLD, 12));
		jlblBackcalculatedTemperatureProgram = new JLabel();
		jlblBackcalculatedTemperatureProgram.setBounds(new Rectangle(12, 4, 453, 16));
		jlblBackcalculatedTemperatureProgram.setForeground(new Color(51, 51, 51));
		jlblBackcalculatedTemperatureProgram.setText("Back-Calculated Temperature Profile");
		jlblBackcalculatedTemperatureProgram.setFont(new Font("Dialog", Font.BOLD, 12));
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 1898, 615));
        this.setPreferredSize(new Dimension(890,570));
        this.setMinimumSize(new Dimension(890,570));

		m_GraphControlTemp = new GraphControl();
		m_GraphControlTemp.setControlsEnabled(false);

		m_GraphControlHoldUp = new GraphControl();
		m_GraphControlHoldUp.setControlsEnabled(false);

		this.add(getJbtnNextStep(), null);
		this.add(getJbtnPreviousStep(), null);
		this.add(getJpanelGradientProfile(), null);
		this.add(getJpanelFlowProfile(), null);
		this.setVisible(true);
		this.add(getJbtnHelp(), null);
		this.add(getJpanelStep4(), null);
		this.add(getJpanelStep5(), null);
		this.add(getJpanelStep6(), null);
		this.add(jlblBackcalculatedTemperatureProgram, null);
		this.add(jlblBackcalculatedHoldUpTime, null);
		
		this.tmOutputModel.addTableModelListener(this);
		this.addComponentListener(this);
	}

	/**
	 * This method initializes jbtnNextStep	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnNextStep() {
		if (jbtnNextStep == null) {
			jbtnNextStep = new JButton();
			jbtnNextStep.setHorizontalAlignment(SwingConstants.CENTER);
			jbtnNextStep.setHorizontalTextPosition(SwingConstants.LEADING);
			jbtnNextStep.setIcon(new ImageIcon(getClass().getResource("/org/retentionprediction/images/forward.png")));
			jbtnNextStep.setText("Next Step  ");
			jbtnNextStep.setEnabled(true);
			jbtnNextStep.setBounds(new Rectangle(760, 576, 178, 36));
			jbtnNextStep.setActionCommand("Next Step2");
		}
		return jbtnNextStep;
	}

	/**
	 * This method initializes jbtnPreviousStep	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnPreviousStep() {
		if (jbtnPreviousStep == null) {
			jbtnPreviousStep = new JButton();
			jbtnPreviousStep.setHorizontalAlignment(SwingConstants.CENTER);
			jbtnPreviousStep.setHorizontalTextPosition(SwingConstants.TRAILING);
			jbtnPreviousStep.setIcon(new ImageIcon(getClass().getResource("/org/retentionprediction/images/back.png")));
			jbtnPreviousStep.setText("  Previous Step");
			jbtnPreviousStep.setBounds(new Rectangle(6, 576, 178, 36));
			jbtnPreviousStep.setActionCommand("Previous Step");
		}
		return jbtnPreviousStep;
	}

	/**
	 * This method initializes jpanelGradientProfile	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanelGradientProfile() {
		if (jpanelGradientProfile == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jpanelGradientProfile = new JPanel();
			jpanelGradientProfile.setLayout(gridLayout);
			jpanelGradientProfile.setPreferredSize(new Dimension(615, 477));
			jpanelGradientProfile.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			jpanelGradientProfile.setSize(new Dimension(469, 253));
			jpanelGradientProfile.setLocation(new Point(8, 24));
			jpanelGradientProfile.add(m_GraphControlTemp, null);
		}
		return jpanelGradientProfile;
	}

	/**
	 * This method initializes jpanelFlowProfile	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanelFlowProfile() {
		if (jpanelFlowProfile == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jpanelFlowProfile = new JPanel();
			jpanelFlowProfile.setLayout(gridLayout1);
			jpanelFlowProfile.setPreferredSize(new Dimension(615, 477));
			jpanelFlowProfile.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			jpanelFlowProfile.setSize(new Dimension(469, 261));
			jpanelFlowProfile.setLocation(new Point(8, 304));
			jpanelFlowProfile.add(m_GraphControlHoldUp, null);
		}
		return jpanelFlowProfile;
	}

	/**
	 * This method initializes jpanelStep5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanelStep4() {
		if (jpanelStep4 == null) {
			jLabel1111 = new JLabel();
			jLabel1111.setBounds(new Rectangle(68, 472, 173, 16));
			jLabel1111.setText("Status:");
			jlblPercentImprovement = new JLabel();
			jlblPercentImprovement.setBounds(new Rectangle(248, 412, 145, 17));
			jlblPercentImprovement.setText("");
			jLabel121 = new JLabel();
			jLabel121.setBounds(new Rectangle(68, 412, 173, 16));
			jLabel121.setText("% improvement:");
			jlblLastVariance = new JLabel();
			jlblLastVariance.setBounds(new Rectangle(248, 392, 145, 17));
			jlblLastVariance.setText("");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(68, 392, 173, 16));
			jLabel12.setText("Last iteration variance:");
			jlblTimeElapsed = new JLabel();
			jlblTimeElapsed.setBounds(new Rectangle(248, 452, 145, 17));
			jlblTimeElapsed.setText("");
			jlblPhase = new JLabel();
			jlblPhase.setBounds(new Rectangle(248, 432, 145, 17));
			jlblPhase.setText("I");
			jlblVariance = new JLabel();
			jlblVariance.setBounds(new Rectangle(248, 372, 145, 16));
			jlblVariance.setText("");
			jLabel111 = new JLabel();
			jLabel111.setBounds(new Rectangle(68, 452, 173, 16));
			jLabel111.setText("Time Elapsed:");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(68, 432, 173, 16));
			jLabel11.setText("Phase:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(68, 372, 173, 16));
			jLabel1.setText("Variance (\u03C3\u00B2):");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(68, 352, 173, 16));
			jLabel.setText("Iteration #:");
			jlblIterationNumber = new JLabel();
			jlblIterationNumber.setBounds(new Rectangle(248, 352, 145, 16));
			jlblIterationNumber.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jlblIterationNumber.setText("");
			jpanelStep4 = new JPanel();
			jpanelStep4.setLayout(null);
			jpanelStep4.setBorder(BorderFactory.createTitledBorder(null, "Step #3: Back-Calculate Temperature and Hold-Up Time Profiles", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jpanelStep4.setBounds(new Rectangle(476, 0, 461, 569));
			jpanelStep4.add(getJScrollPane(), null);
			jpanelStep4.add(getJbtnCalculate(), null);
			jpanelStep4.add(jlblIterationNumber, null);
			jpanelStep4.add(jLabel, null);
			jpanelStep4.add(jLabel1, null);
			jpanelStep4.add(jLabel11, null);
			jpanelStep4.add(jLabel111, null);
			jpanelStep4.add(jlblVariance, null);
			jpanelStep4.add(jlblPhase, null);
			jpanelStep4.add(jlblTimeElapsed, null);
			jpanelStep4.add(jLabel12, null);
			jpanelStep4.add(jlblLastVariance, null);
			jpanelStep4.add(jLabel121, null);
			jpanelStep4.add(jlblPercentImprovement, null);
			jpanelStep4.add(getJProgressBar(), null);
			jpanelStep4.add(jLabel1111, null);
		}
		return jpanelStep4;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(8, 24, 445, 321));
			jScrollPane.setViewportView(getJtableOutput());
		}
		return jScrollPane;
	}

	class NoEditTableModel extends DefaultTableModel 
	{
	    public NoEditTableModel(final Object[] columnNames, final int rowCount) 
	    {
	        super(convertToVector(columnNames), rowCount);
	    }
	    
	    public NoEditTableModel(final Object[][] data, final Object[] columnNames) 
	    {
	        setDataVector(data, columnNames);
	    }

	    public boolean isCellEditable(int row, int column) 
	    {
	        //Note that the data/cell address is constant,
	        //no matter where the cell appears onscreen.
	        return false;
	    }
	    
	    /*
	     * JTable uses this method to determine the default renderer/
	     * editor for each cell.  If we didn't implement this method,
	     * then the last column would contain text ("true"/"false"),
	     * rather than a check box.
	     */
	    //public Class getColumnClass(int c) {
	    //    return getValueAt(0, c).getClass();
	    //}

	}
	
	class TestCompoundsTableModel extends DefaultTableModel 
	{
	    public TestCompoundsTableModel(final Object[] columnNames, final int rowCount) 
	    {
	        super(convertToVector(columnNames), rowCount);
	    }
	    
	    public TestCompoundsTableModel(final Object[][] data, final Object[] columnNames) 
	    {
	        setDataVector(data, columnNames);
	    }

	    public boolean isCellEditable(int row, int column) 
	    {
	        //Note that the data/cell address is constant,
	        //no matter where the cell appears onscreen.
	    	if (column == 3)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    /*
	     * JTable uses this method to determine the default renderer/
	     * editor for each cell.  If we didn't implement this method,
	     * then the last column would contain text ("true"/"false"),
	     * rather than a check box.
	     */
	    //public Class getColumnClass(int c) {
	        //return getValueAt(0, c).getClass();
	    //}

	}
	
	// This TableCellEditor, if a JTextField, automatically selects all the text when it is created.
	// This makes it so that when you type something into the cell, it removes whatever was there
	// It does not make it select all on double-click
	class TableCellEditorCustom extends DefaultCellEditor
	{
		public TableCellEditorCustom(JTextField textField) {
			super(textField);

		}
		
		@Override
	    public Component getTableCellEditorComponent(JTable table, Object value,
				 boolean isSelected,
				 int row, int column) 
	    {
    		java.awt.Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column);
    		if (c instanceof javax.swing.JTextField)
    		{
    			JTextField jtf = ((javax.swing.JTextField)c);
    			jtf.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
    			//Rectangle rect = table.getCellRect(row, column, false);
    			//jtf.setSize(rect.width, rect.height);
    			jtf.setHorizontalAlignment(JTextField.RIGHT);
    			jtf.selectAll();
    			//jtf.setText("");
    			//jtf.setCaretPosition(0);
    		}
    		return c;
	    }
	    
		@Override
	    public Object getCellEditorValue() 
		{
			Object obj = delegate.getCellEditorValue();

		    
			if (obj.equals(""))
				return "";
			else
			{
				boolean bIsAcceptableNumber = true;
				try {
			        Float test = Float.parseFloat((String)obj);
			    } catch (NumberFormatException e) {
			        bIsAcceptableNumber = false;
			    }
			    
			    if (bIsAcceptableNumber)
			    	return (Double)(double)Float.valueOf((String)obj);
			    else
			    	return "";
			}
	    }
	}
	
	/**
	 * This method initializes jtableOutput	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJtableOutput() {
		if (jtableOutput == null) 
		{
			Object[] columnNames = {"Compound", "Expt tR (min)", "Calc tR (min)", "Diff (min)"};
			tmOutputModel = new NoEditTableModel(columnNames, 0);
			jtableOutput = new JTable(tmOutputModel);
			
			jtableOutput.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

			jtableOutput.setBounds(new Rectangle(0, 0, 20, 20));
			
			jtableOutput.getColumnModel().getColumn(0).setPreferredWidth(200);
			
			jtableOutput.setAutoCreateColumnsFromModel(false);
		}
		return jtableOutput;
	}

	/**
	 * This method initializes jbtnCalculate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnCalculate() {
		if (jbtnCalculate == null) {
			jbtnCalculate = new JButton();
			jbtnCalculate.setText("Back-Calculate Profiles");
			jbtnCalculate.setLocation(new Point(128, 520));
			jbtnCalculate.setSize(new Dimension(213, 36));
			jbtnCalculate.setActionCommand("Calculate");
		}
		return jbtnCalculate;
	}

	@Override
	public void tableChanged(TableModelEvent arg0) 
	{
	    //Vector data = tmOutputModel.getDataVector();
	    //Collections.sort(data, new ColumnSorter(1));
	}

	class ColumnSorter implements Comparator 
	{
		int colIndex;

		ColumnSorter(int colIndex) 
		{
			this.colIndex = colIndex;
		}

		public int compare(Object a, Object b) 
		{
		    Vector v1 = (Vector) a;
		    Vector v2 = (Vector) b;
		    Object o1 = v1.get(colIndex);
		    Object o2 = v2.get(colIndex);
	
		    if (o1 instanceof String && ((String) o1).length() == 0) {
		      o1 = null;
		    }
		    if (o2 instanceof String && ((String) o2).length() == 0) {
		      o2 = null;
		    }
	
		    if (o1 == null && o2 == null) {
		    	return 0;
		    } else if (o1 == null) {
		    	return 1;
		    } else if (o2 == null) {
		    	return -1;
		    } else if (o1 instanceof Comparable) {
	
		    	return ((Comparable) o1).compareTo(o2);
		    } else {
	
		    	return o1.toString().compareTo(o2.toString());
		    }
		}
	}

	/**
	 * This method initializes jbtnHelp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnHelp() {
		if (jbtnHelp == null) {
			jbtnHelp = new JButton();
			jbtnHelp.setText("Help");
			jbtnHelp.setLocation(new Point(572, 576));
			jbtnHelp.setSize(new Dimension(178, 34));
			jbtnHelp.setEnabled(false);
			jbtnHelp.setForeground(Color.blue);
			jbtnHelp.setVisible(false);
		}
		return jbtnHelp;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new Rectangle(68, 492, 325, 25));
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jpanelStep6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanelStep6() {
		if (jpanelStep6 == null) {
			jlblPercent = new JLabel();
			jlblPercent.setBounds(new Rectangle(412, 32, 25, 16));
			jlblPercent.setText("%");
			jlblToleranceWindow = new JLabel();
			jlblToleranceWindow.setBounds(new Rectangle(12, 32, 341, 16));
			jlblToleranceWindow.setText("Select retention time tolerance window confidence:");
			jLabel11111 = new JLabel();
			jLabel11111.setBounds(new Rectangle(68, 476, 173, 16));
			jLabel11111.setText("Status:");
			jpanelStep6 = new JPanel();
			jpanelStep6.setLayout(null);
			jpanelStep6.setBorder(BorderFactory.createTitledBorder(null, "Step #6: Predict Retention of All Compounds in Database", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jpanelStep6.setVisible(true);
			jpanelStep6.setBounds(new Rectangle(1412, 0, 453, 569));
			jpanelStep6.add(getJScrollPane1(), null);
			jpanelStep6.add(getJProgressBar2(), null);
			jpanelStep6.add(getJbtnPredict(), null);
			jpanelStep6.add(jLabel11111, null);
			jpanelStep6.add(jlblToleranceWindow, null);
			jpanelStep6.add(getJtxtWindowConfidence(), null);
			jpanelStep6.add(jlblPercent, null);
		}
		return jpanelStep6;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(8, 56, 437, 413));
			jScrollPane1.setViewportView(getJtablePredictions());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jtablePredictions	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJtablePredictions() {
		if (jtablePredictions == null) 
		{
			Object[] columnNames = {"Compound", "Predicted tR (min)", "Tolerance window (+/- min)"};
			tmPredictionModel = new NoEditTableModel(columnNames, 0);
			jtablePredictions = new JTable(tmPredictionModel);
			
			jtablePredictions.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jtablePredictions.setCellSelectionEnabled(true);

			jtablePredictions.setBounds(new Rectangle(0, 0, 20, 20));
			
			jtablePredictions.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

			jtablePredictions.getColumnModel().getColumn(0).setPreferredWidth(110);
			jtablePredictions.getColumnModel().getColumn(1).setPreferredWidth(100);
			
			jtablePredictions.setAutoCreateColumnsFromModel(false);
		}
		return jtablePredictions;
	}

	/**
	 * This method initializes jProgressBar2	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar2() {
		if (jProgressBar2 == null) {
			jProgressBar2 = new JProgressBar();
			jProgressBar2.setStringPainted(true);
			jProgressBar2.setBounds(new Rectangle(68, 496, 325, 25));
		}
		return jProgressBar2;
	}

	/**
	 * This method initializes jbtnPredict	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnPredict() {
		if (jbtnPredict == null) {
			jbtnPredict = new JButton();
			jbtnPredict.setText("Predict Retention Times");
			jbtnPredict.setBounds(new Rectangle(144, 524, 178, 34));
			jbtnPredict.setActionCommand("Predict");
		}
		return jbtnPredict;
	}
	
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean getScrollableTracksViewportHeight() {
		Dimension minSize = this.getMinimumSize();
		Dimension portSize = null;
		if (getParent() instanceof JViewport) 
		{
			JViewport port = (JViewport)getParent();
			portSize = port.getSize();
		}
		else
			return false;
		
		if (portSize.height < minSize.height)
			return false;
		else
			return true;
	}


	@Override
	public boolean getScrollableTracksViewportWidth() {
		Dimension minSize = this.getMinimumSize();
		Dimension portSize = null;
		if (getParent() instanceof JViewport) 
		{
			JViewport port = (JViewport)getParent();
			portSize = port.getSize();
		}
		else
			return false;
		
		if (portSize.width < minSize.width)
			return false;
		else
			return true;
	}


	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentMoved(ComponentEvent arg0) {
		this.revalidate();
	}


	@Override
	public void componentResized(ComponentEvent arg0) 
	{
		// Respond to window resize
		if (arg0.getComponent() == this)
		{
			Dimension size = this.getSize();
			this.jbtnPreviousStep.setLocation(jbtnPreviousStep.getX(), size.height - jbtnPreviousStep.getHeight() - 6);
			this.jbtnNextStep.setLocation(size.width - 6 - jbtnNextStep.getWidth(), size.height - jbtnNextStep.getHeight() - 6);
			this.jbtnHelp.setLocation(jbtnNextStep.getX() - 10 - jbtnNextStep.getWidth(), size.height - jbtnHelp.getHeight() - 6);
			
			this.jpanelStep4.setLocation(((size.width) / 2) + 3, jpanelStep4.getY());
			this.jpanelStep4.setSize(size.width - jpanelStep4.getX() - 6, size.height - 6 - jbtnNextStep.getHeight() - 6);
			this.jbtnCalculate.setLocation((jpanelStep4.getWidth() / 2) - (jbtnCalculate.getWidth() / 2), jpanelStep4.getHeight() - 15 - jbtnCalculate.getHeight());
			this.jProgressBar.setLocation((jpanelStep4.getWidth() / 2) - (jProgressBar.getWidth() / 2), jbtnCalculate.getY() - jProgressBar.getHeight() - 12);
			this.jLabel1111.setLocation(jProgressBar.getX(), jProgressBar.getY() - 4 - jLabel1111.getHeight());
			this.jLabel111.setLocation(jLabel1111.getX(), jLabel1111.getY() - 4 - jLabel111.getHeight());
			this.jLabel11.setLocation(jLabel111.getX(), jLabel111.getY() - 4 - jLabel11.getHeight());
			this.jLabel121.setLocation(jLabel11.getX(), jLabel11.getY() - 4 - jLabel121.getHeight());
			this.jLabel12.setLocation(jLabel121.getX(), jLabel121.getY() - 4 - jLabel12.getHeight());
			this.jLabel1.setLocation(jLabel12.getX(), jLabel12.getY() - 4 - jLabel1.getHeight());
			this.jLabel.setLocation(jLabel1.getX(), jLabel1.getY() - 4 - jLabel.getHeight());
			this.jScrollPane.setSize(jpanelStep4.getWidth() - 8 - 8, jLabel.getY() - 6 - jScrollPane.getY());
			this.jlblTimeElapsed.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblTimeElapsed.getWidth(), jLabel111.getY());
			this.jlblPhase.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblPhase.getWidth(), jLabel11.getY());
			this.jlblPercentImprovement.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblPercentImprovement.getWidth(), jLabel121.getY());
			this.jlblLastVariance.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblLastVariance.getWidth(), jLabel12.getY());
			this.jlblVariance.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblVariance.getWidth(), jLabel1.getY());
			this.jlblIterationNumber.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblIterationNumber.getWidth(), jLabel.getY());

			this.jpanelStep5.setLocation(((size.width) / 2) + 3, jpanelStep4.getY());
			this.jpanelStep5.setSize(size.width - jpanelStep4.getX() - 6, size.height - 6 - jbtnNextStep.getHeight() - 6);
			this.jSliderIndicator.setLocation(72, jpanelStep5.getHeight() - jSliderIndicator.getHeight() - 8);
			this.jSliderIndicator.setSize(jpanelStep5.getWidth() - (72 * 2), 69);
			this.jlblGood.setLocation(16, jSliderIndicator.getY() + 16);
			this.jlblBad.setLocation(jSliderIndicator.getX() + jSliderIndicator.getWidth() + 8, jSliderIndicator.getY() + 16);
			this.jlblColumnRatingName.setLocation((jpanelStep5.getWidth() / 2) - 4 - jlblColumnRatingName.getWidth(), jSliderIndicator.getY() - jlblColumnRatingName.getHeight() - 16);
			this.jlblColumnRating.setLocation((jpanelStep5.getWidth() / 2) + 4, jSliderIndicator.getY() - jlblColumnRating.getHeight() - 16);
			this.jlblExpectedStandardDeviationName.setLocation((jpanelStep5.getWidth() / 2) - 4 - jlblExpectedStandardDeviationName.getWidth(), jlblColumnRatingName.getY() - jlblExpectedStandardDeviationName.getHeight() - 4);
			this.jlblExpectedStandardDeviation.setLocation((jpanelStep5.getWidth() / 2) + 4, jlblColumnRating.getY() - jlblExpectedStandardDeviation.getHeight() - 4);
			this.jlblStandardDeviationName.setLocation((jpanelStep5.getWidth() / 2) - 4 - jlblStandardDeviationName.getWidth(), jlblExpectedStandardDeviationName.getY() - jlblStandardDeviationName.getHeight() - 4);
			this.jlblStandardDeviation.setLocation((jpanelStep5.getWidth() / 2) + 4, jlblExpectedStandardDeviation.getY() - jlblStandardDeviation.getHeight() - 4);
			this.jbtnAutomaticDetermineTestCompounds.setLocation((jpanelStep5.getWidth() / 2) - (jbtnAutomaticDetermineTestCompounds.getWidth() / 2), jlblStandardDeviation.getY() - 16 - jbtnAutomaticDetermineTestCompounds.getHeight());
			this.jScrollPane2.setSize(jpanelStep4.getWidth() - 8 - 8, jbtnAutomaticDetermineTestCompounds.getY() - 6 - jScrollPane2.getY());
			this.jlblInstructions.setSize(jpanelStep4.getWidth() - 8 - 8, jlblInstructions.getHeight());
			/*this.jbtnCalculate.setLocation((jpanelStep4.getWidth() / 2) - (jbtnCalculate.getWidth() / 2), jpanelStep4.getHeight() - 15 - jbtnCalculate.getHeight());
			this.jProgressBar.setLocation((jpanelStep4.getWidth() / 2) - (jProgressBar.getWidth() / 2), jbtnCalculate.getY() - jProgressBar.getHeight() - 12);
			this.jLabel1111.setLocation(jProgressBar.getX(), jProgressBar.getY() - 4 - jLabel1111.getHeight());
			this.jLabel111.setLocation(jLabel1111.getX(), jLabel1111.getY() - 4 - jLabel111.getHeight());
			this.jLabel11.setLocation(jLabel111.getX(), jLabel111.getY() - 4 - jLabel11.getHeight());
			this.jLabel121.setLocation(jLabel11.getX(), jLabel11.getY() - 4 - jLabel121.getHeight());
			this.jLabel12.setLocation(jLabel121.getX(), jLabel121.getY() - 4 - jLabel12.getHeight());
			this.jLabel1.setLocation(jLabel12.getX(), jLabel12.getY() - 4 - jLabel1.getHeight());
			this.jLabel.setLocation(jLabel1.getX(), jLabel1.getY() - 4 - jLabel.getHeight());
			this.jScrollPane.setSize(jpanelStep4.getWidth() - 8 - 8, jLabel.getY() - 6 - jScrollPane.getY());
			this.jlblTimeElapsed.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblTimeElapsed.getWidth(), jLabel111.getY());
			this.jlblPhase.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblPhase.getWidth(), jLabel11.getY());
			this.jlblPercentImprovement.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblPercentImprovement.getWidth(), jLabel121.getY());
			this.jlblLastVariance.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblLastVariance.getWidth(), jLabel12.getY());
			this.jlblVariance.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblVariance.getWidth(), jLabel1.getY());
			this.jlblIterationNumber.setLocation((jProgressBar.getX() + jProgressBar.getWidth()) - this.jlblIterationNumber.getWidth(), jLabel.getY());
*/
			this.jpanelStep6.setLocation(jpanelStep4.getLocation());
			this.jpanelStep6.setSize(jpanelStep4.getSize());
			this.jbtnPredict.setLocation((jpanelStep6.getWidth() / 2) - (jbtnPredict.getWidth() / 2), jpanelStep6.getHeight() - 15 - jbtnPredict.getHeight());
			this.jProgressBar2.setLocation((jpanelStep6.getWidth() / 2) - (jProgressBar2.getWidth() / 2), jbtnPredict.getY() - jProgressBar2.getHeight() - 12);
			this.jLabel11111.setLocation(jProgressBar2.getX(), jProgressBar2.getY() - 4 - jLabel11111.getHeight());
			this.jScrollPane1.setSize(jpanelStep6.getWidth() - 8 - 8, jLabel11111.getY() - 6 - jScrollPane1.getY());
			this.jlblPercent.setLocation(jScrollPane1.getX() + jScrollPane1.getWidth() - jlblPercent.getWidth(), jlblPercent.getY());
			this.jtxtWindowConfidence.setLocation(jlblPercent.getX() - 4 - jtxtWindowConfidence.getWidth(), jtxtWindowConfidence.getY());
			
			this.jpanelGradientProfile.setSize(size.width - jpanelStep4.getX() - 6, (size.height - 6 - 24 - 24 - jbtnHelp.getHeight() - 6 - 6) / 2);
			this.m_GraphControlTemp.repaint();

			this.jlblBackcalculatedHoldUpTime.setLocation(jlblBackcalculatedHoldUpTime.getX(), jpanelGradientProfile.getY() + jpanelGradientProfile.getHeight() + 6);

			this.jpanelFlowProfile.setLocation(jpanelFlowProfile.getX(), jpanelGradientProfile.getY() + jpanelGradientProfile.getHeight() + 3 + 24);
			this.jpanelFlowProfile.setSize(jpanelGradientProfile.getWidth(), size.height - jpanelFlowProfile.getY() - 6 - jbtnHelp.getHeight() - 6);
			this.m_GraphControlHoldUp.repaint();
			/*this.jpanelStep4.setSize(this.jpanelStep4.getWidth(), size.height - 438);
			this.jScrollPane1.setSize(this.jScrollPane1.getWidth(), size.height - 438 - 28);
			this.jtableMeasuredRetentionTimes.revalidate();
			this.jbtnNextStep.setLocation((int)size.getWidth() - this.jbtnNextStep.getWidth() - 6, (int)size.getHeight() - jbtnNextStep.getHeight() - 6);
			this.jbtnHelp.setLocation(this.jbtnNextStep.getLocation().x - this.jbtnHelp.getWidth() - 10, (int)size.getHeight() - jbtnHelp.getHeight() - 6);
			this.jbtnPreloadedValues.setLocation(this.jbtnPreloadedValues.getLocation().x, (int)size.getHeight() - jbtnPreloadedValues.getHeight() - 6);
			this.jpanelSimulatedChromatogram.setSize(size.width - jpanelSimulatedChromatogram.getLocation().x - 6, ((size.height - 6 - 6 - this.jbtnNextStep.getHeight()) * 5) / 10);
			this.m_GraphControlTemp.setSize(jpanelSimulatedChromatogram.getWidth() - 3 - 5, jpanelSimulatedChromatogram.getHeight() - 16 - 3);
			this.m_GraphControlTemp.repaint();
			this.jpanelFlowProfile.setLocation(jpanelFlowProfile.getX(), jpanelSimulatedChromatogram.getY() + jpanelSimulatedChromatogram.getHeight() + 6);
			this.jpanelFlowProfile.setSize(jpanelSimulatedChromatogram.getWidth(), size.height - jpanelFlowProfile.getY() - 6 - 6 - this.jbtnNextStep.getHeight());
			this.m_GraphControlHoldUp.setSize(jpanelFlowProfile.getWidth() - 3 - 5, jpanelFlowProfile.getHeight() - 16 - 3);
			this.m_GraphControlHoldUp.repaint();*/
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method initializes jPanelStep5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanelStep5() {
		if (jpanelStep5 == null) {
			jlblColumnRating = new JLabel();
			jlblColumnRating.setBounds(new Rectangle(244, 460, 169, 17));
			jlblColumnRating.setText("");
			jlblColumnRatingName = new JLabel();
			jlblColumnRatingName.setBounds(new Rectangle(36, 460, 201, 16));
			jlblColumnRatingName.setText("Your column's rating:");
			jlblColumnRatingName.setFont(new Font("Dialog", Font.BOLD, 12));
			jlblExpectedStandardDeviation = new JLabel();
			jlblExpectedStandardDeviation.setBounds(new Rectangle(244, 440, 169, 17));
			jlblExpectedStandardDeviation.setText("");
			jlblExpectedStandardDeviationName = new JLabel();
			jlblExpectedStandardDeviationName.setBounds(new Rectangle(36, 440, 201, 16));
			jlblExpectedStandardDeviationName.setText("Most likely error for a new column:");
			jlblExpectedStandardDeviationName.setFont(new Font("Dialog", Font.BOLD, 12));
			jlblInstructions = new JLabel();
			jlblInstructions.setBounds(new Rectangle(12, 28, 437, 69));
			jlblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
			jlblInstructions.setHorizontalTextPosition(SwingConstants.CENTER);
			jlblInstructions.setText("<html>Enter the retention times of each of the 12 test compounds in the \"Measured tR\" column. Either enter them manually or click the \"Find retention times automatically...\" button to automatically extract them from your GC-MS data file.  </html>");
			jlblInstructions.setVerticalAlignment(SwingConstants.CENTER);
			jlblInstructions.setFont(new Font("Dialog", Font.PLAIN, 12));
			jlblBad = new JLabel();
			jlblBad.setBounds(new Rectangle(408, 508, 41, 16));
			jlblBad.setText("Poor");
			jlblGood = new JLabel();
			jlblGood.setBounds(new Rectangle(12, 508, 57, 16));
			jlblGood.setText("Like new");
			jlblStandardDeviationName = new JLabel();
			jlblStandardDeviationName.setText("Your overall prediction error:");
			jlblStandardDeviationName.setSize(new Dimension(201, 17));
			jlblStandardDeviationName.setFont(new Font("Dialog", Font.BOLD, 12));
			jlblStandardDeviationName.setLocation(new Point(36, 420));
			jlblStandardDeviation = new JLabel();
			jlblStandardDeviation.setText("");
			jlblStandardDeviation.setSize(new Dimension(169, 17));
			jlblStandardDeviation.setLocation(new Point(244, 420));
			jpanelStep5 = new JPanel();
			jpanelStep5.setLayout(null);
			jpanelStep5.setBorder(BorderFactory.createTitledBorder(null, "Step #4: Check System Suitability", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jpanelStep5.setLocation(new Point(944, 0));
			jpanelStep5.setSize(new Dimension(461, 569));
			jpanelStep5.setVisible(true);
			jpanelStep5.add(getJScrollPane2(), null);
			jpanelStep5.add(getJbtnAutomaticDetermineTestCompounds(), null);
			jpanelStep5.add(jlblStandardDeviation, null);
			jpanelStep5.add(jlblStandardDeviationName, null);
			jpanelStep5.add(getJSliderIndicator(), null);
			jpanelStep5.add(jlblGood, null);
			jpanelStep5.add(jlblBad, null);
			jpanelStep5.add(jlblInstructions, null);
			jpanelStep5.add(jlblExpectedStandardDeviationName, null);
			jpanelStep5.add(jlblExpectedStandardDeviation, null);
			jpanelStep5.add(jlblColumnRatingName, null);
			jpanelStep5.add(jlblColumnRating, null);
		}
		return jpanelStep5;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(12, 104, 437, 257));
			jScrollPane2.setViewportView(getJtableTestCompoundPredictions());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jtableTestCompoundPredictions	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJtableTestCompoundPredictions() {
		if (jtableTestCompoundPredictions == null) {

			Object[] columnNames = {"Compound", "m/z", "Predicted tR (min)", "Measured tR (min)", "Error (min)"};
			Object[][] data = new Object[Globals.TestCompoundNameArray.length][5];
			for (int i = 0; i < Globals.TestCompoundNameArray.length; i++)
			{
				data[i][0] = Globals.TestCompoundNameArray[i];
				String str = "";
				for (int j = 0; j < Globals.TestCompoundMZArray[i].length; j++)
				{
					str += Globals.TestCompoundMZArray[i][j];
					if (j < Globals.TestCompoundMZArray[i].length - 1)
						str += ", ";
				}
				data[i][1] = str;
				data[i][2] = (Object)0.0;
				data[i][3] = (String)"";
				data[i][4] = (Object)0.0;
			}
			
			m_tmTestCompoundsModel = new TestCompoundsTableModel(data, columnNames);
			jtableTestCompoundPredictions = new JTable(m_tmTestCompoundsModel);
			
			jtableTestCompoundPredictions.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jtableTestCompoundPredictions.setCellSelectionEnabled(true);

			jtableTestCompoundPredictions.getColumnModel().getColumn(0).setPreferredWidth(120);

			jtableTestCompoundPredictions.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

			JTextField jtf = new JTextField();
			TableCellEditorCustom cellEditor = new TableCellEditorCustom(jtf);
			jtableTestCompoundPredictions.getColumnModel().getColumn(3).setCellEditor(cellEditor);
		}
		return jtableTestCompoundPredictions;
	}

	/**
	 * This method initializes jbtnAutomaticDetermineTestCompounds	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnAutomaticDetermineTestCompounds() {
		if (jbtnAutomaticDetermineTestCompounds == null) {
			jbtnAutomaticDetermineTestCompounds = new JButton();
			jbtnAutomaticDetermineTestCompounds.setText("Find retention times automatically...");
			jbtnAutomaticDetermineTestCompounds.setLocation(new Point(96, 368));
			jbtnAutomaticDetermineTestCompounds.setSize(new Dimension(261, 34));
			jbtnAutomaticDetermineTestCompounds.setActionCommand("Automatically Determine Test Compound Retention Times");
		}
		return jbtnAutomaticDetermineTestCompounds;
	}

	/**
	 * This method initializes jSliderIndicator	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private SliderIndicator getJSliderIndicator() {
		if (jSliderIndicator == null) {
			jSliderIndicator = new SliderIndicator();
			jSliderIndicator.setLayout(new GridBagLayout());
			jSliderIndicator.setBounds(new Rectangle(72, 492, 329, 69));
		}
		return jSliderIndicator;
	}

	/**
	 * This method initializes jtxtWindowConfidence	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtxtWindowConfidence() {
		if (jtxtWindowConfidence == null) {
			jtxtWindowConfidence = new JTextField();
			jtxtWindowConfidence.setBounds(new Rectangle(356, 28, 53, 26));
			jtxtWindowConfidence.setHorizontalAlignment(JTextField.TRAILING);
			jtxtWindowConfidence.setText("95.0");
		}
		return jtxtWindowConfidence;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
