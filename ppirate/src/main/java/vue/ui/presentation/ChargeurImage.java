/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.presentation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author loferga
 */
public class ChargeurImage {
	
	private ChargeurImage() {
	    throw new IllegalStateException("Utility class");
	}
	
    private static final ClassLoader chargeurClasse=ChargeurImage.class.getClassLoader();
    
    public static BufferedImage chargerImage(String cheminVersLaRessource){
        try{
            URL ressourceURL=chargeurClasse.getResource(cheminVersLaRessource);
            return ImageIO.read(ressourceURL);
        }catch(IOException e){
            Logger.getLogger(ChargeurImage.class.getName()).log(Level.SEVERE,"impossible d ouvrir {0}",cheminVersLaRessource);
            return null;
        }
    }
    
    public static ImageIcon chargerIcon(String cheminVersLaRessource){
        URL ressourceURL=chargeurClasse.getResource(cheminVersLaRessource);
        return new ImageIcon(ressourceURL);
    }
    
    
    
}
