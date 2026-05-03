package telas;
import javax.swing.*;
public class AlertaUtil {

    private static final 
    Icon ICON_SUCESSO =
            new ImageIcon(AlertaUtil.class.getResource("/imagens/sucesso.png"));
    private static final 
    Icon ICON_ERROR =
            new ImageIcon(AlertaUtil.class.getResource("/imagens/error.png"));
    private static final 
    Icon ICON_AVISO =
            new ImageIcon(AlertaUtil.class.getResource("/imagens/aviso.png"));
    
	    public static void erro(String mensagem) {
	        JOptionPane.showMessageDialog(
	            null,
	            mensagem,
	            "Erro",
	            JOptionPane.INFORMATION_MESSAGE,
	            ICON_ERROR
	        );
	    }

	    /**
	     * @wbp.parser.entryPoint
	     */
	    public static void info(String mensagem) {
	        JOptionPane.showMessageDialog(
	            null,
	            mensagem,
	            "Informação",
	            JOptionPane.INFORMATION_MESSAGE
	        );
	    }

	    public static void aviso(String mensagem) {
	        JOptionPane.showMessageDialog(
	            null,
	            mensagem,
	            "Aviso",
	            JOptionPane.WARNING_MESSAGE,
	            ICON_AVISO
	        );
	    }
	    
	    public static void alerta(String mensagem) {
	        JOptionPane.showMessageDialog(
	            null,
	            mensagem,
	            "Cadastrado com sucesso!",
	            JOptionPane.INFORMATION_MESSAGE,
	            ICON_SUCESSO
	        );
	    }
}


