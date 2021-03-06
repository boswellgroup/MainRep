package visualizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;


public class HPLCPartTubeJoint extends HPLCPart
{
	private static final long serialVersionUID = 1L;

	public HPLCPartTubeJoint() 
	{
		super("");
		this.width = 1;
		this.height = 1;
		
		ConnectionNode newNode = new ConnectionNode(this, 2);
		newNode.setX((width * Globals.gridSpacing) / 2);
		newNode.setY((height * Globals.gridSpacing) / 2);
		this.connectionNodes.add(newNode);
	}
	
	@Override
	public void drawPart(Graphics2D g2d, Point position)
	{
		super.drawPart(g2d, position);
		
/*		BufferedImage bufferedImage = new BufferedImage(width * Globals.gridSpacing + 1, height * Globals.gridSpacing + 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2dImg = bufferedImage.createGraphics();
		g2dImg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Font arial = new Font("Arial", Font.BOLD, 12);

		// Draw box first
		g2dImg.setColor(Color.LIGHT_GRAY);
		g2dImg.fillRoundRect(0, 0, width * Globals.gridSpacing, height * Globals.gridSpacing, 5, 5);
		g2dImg.setColor(Color.DARK_GRAY);
		g2dImg.drawRoundRect(0, 0, width * Globals.gridSpacing, height * Globals.gridSpacing, 5, 5);
		
		// Draw name at bottom
		Point center = new Point(position.x + (width * Globals.gridSpacing) / 2, position.y + (height * Globals.gridSpacing) / 2);
		g2d.setColor(Color.BLACK);
		g2d.setFont(arial);
		String str = name;
		double strWidth = g2d.getFontMetrics().getStringBounds(str, g2d).getWidth();
		double strHeight = g2d.getFontMetrics().getStringBounds(str, g2d).getHeight();
		g2d.drawString(str, center.x - (int)(strWidth / 2), position.y + (height * Globals.gridSpacing) + (int)(0.5 * strHeight) + (int)(strHeight / 2));

		TexturePaint texture = new TexturePaint(bufferedImage, new Rectangle(position.x, position.y, this.width * Globals.gridSpacing, this.height * Globals.gridSpacing));
		g2d.setPaint(texture);
		g2d.fillRect(position.x, position.y, this.width * Globals.gridSpacing + 1, this.height * Globals.gridSpacing + 1);
*/
		//drawConnectionNodes(g2d, position);
	}
	
	@Override
	public void drawOverlay(Graphics2D g2d, Point position, boolean bGreen)
	{
		AlphaComposite myAlpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
		g2d.setComposite(myAlpha);

		if (bGreen)
			g2d.setColor(Color.GREEN);
		else
			g2d.setColor(Color.RED);
		
		g2d.fillRect(position.x, position.y, width * Globals.gridSpacing + 1, height * Globals.gridSpacing + 1);

		myAlpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		g2d.setComposite(myAlpha);		

		//drawConnectionNodes(g2d, position);
	}
}
