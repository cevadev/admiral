package org.admiral;

import org.admiral.util.Ini;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Admiral {
    static public final String	ID = "Id: Admiral.java, v 1.0";
    static public final String	MAIN_VERSION = "Versi\u00f3n 1.0";
    static public final String	DATE_VERSION = "16-05-2023";
    static public final String	DB_VERSION = "16-05-2023";
    static public final String	NAME = "Admiral\u00AE";
    static public final String	NAME2 = "Admiral";
    static public final String	URL = "www.admiralsoftware.org";
    static private final String	s_File16x16 = "images/admiral16.gif";
    static private final String	s_file32x32 = "images/admiral.gif";
    static private final String	s_file100x30 = "images/admiral10030.png";
    static private final String	s_file48x15	= "images/admiral.png";
    static private String	s_supportEmail	= "";
    static public final String	SUB_TITLE = "Software para la gesti\u00f3n empresarial";
    static public final String ADM_R = "Admiral\u00AE";
    static public final String	COPYRIGHT = "\u00A9 2023 Admiral Software";
    static private String	s_ImplementationVersion	= null;
    static private String	s_ImplementationVendor	= null;
    static private Image s_image16;
    static private Image	s_image48x15;
    static private Image	s_imageLogo;
    static private ImageIcon s_imageIcon32;
    static private ImageIcon	s_imageIconLogo;

    private static Logger logger;

    public static synchronized boolean startup(boolean isClient){
        // TODO: 16/5/2023
        System.setProperty("suppressSwingDropSupport", "true");
        Ini.setClient(isClient);
        logger = Logger.getLogger(Admiral.class.getName());
    }
}
