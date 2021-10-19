package cherryconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;


public class CherryConverter {

    private static String MAIN_URL = "https://cjrtnc.leaningtech.com/2.1/runtime/rt.jar.";
    private static String END_URL = "js";
    private static String LIST_URL = "'sun/util/locale/','sun/security/util/math/','sun/security/tools/keytool/','sun/security/ssl/krb5/','sun/security/provider/certpath/','sun/security/krb5/internal/','sun/security/tools/','sun/security/ssl/','sun/security/provider/','sun/security/krb5/','sun/security/util/','sun/security/jgss/','sun/rmi/transport/','sun/print/resources/','sun/nio/cs/ext/','sun/nio/ch/sctp/','sun/nio/cs/','sun/nio/ch/','sun/net/www/','sun/java2d/marlin/','sun/java2d/loops/','sun/java2d/pipe/','sun/awt/image/','sun/awt/resources/','sun/awt/datatransfer/','sun/awt/im/','sun/awt/geom/','sun/awt/dnd/','sun/awt/shell/','sun/awt/util/','sun/awt/windows/','sun/awt/event/','sun/nio/','sun/security/','sun/awt/','sun/java2d/','sun/net/','sun/print/','sun/util/','sun/font/','sun/rmi/','sun/management/','sun/reflect/','sun/swing/','sun/applet/','sun/text/','sun/misc/','org/omg/stub/','org/omg/DynamicAny/','org/omg/CORBA/','org/omg/','jdk/internal/org/objectweb/asm/util/','jdk/internal/org/','javax/xml/bind/','javax/swing/text/html/parser/','javax/swing/text/html/','javax/swing/text/rtf/','javax/swing/plaf/basic/','javax/swing/plaf/nimbus/','javax/swing/plaf/synth/','javax/swing/plaf/metal/','javax/swing/plaf/','javax/swing/text/','javax/swing/tree/','javax/swing/colorchooser/','javax/swing/table/','javax/swing/event/','javax/swing/border/','javax/swing/filechooser/','javax/swing/undo/','javax/management/remote/rmi/','javax/management/remote/','javax/management/modelmbean/','javax/management/relation/','javax/management/openmbean/','javax/swing/','javax/management/','javax/xml/','javax/imageio/','javax/print/','javax/security/','javax/naming/','javax/crypto/','javax/sql/','javax/sound/','java/util/concurrent/locks/','java/util/concurrent/atomic/','java/util/concurrent/','java/util/stream/','java/util/logging/','java/util/prefs/','java/util/regex/','java/util/zip/','java/util/function/','java/util/jar/','java/util/spi/','java/time/format/','java/time/chrono/','java/nio/file/','java/lang/invoke/','java/lang/management/','java/awt/image/','java/awt/geom/','java/awt/font/','java/awt/event/','java/awt/datatransfer/','java/awt/dnd/','java/awt/color/','java/awt/print/','java/awt/peer/','java/awt/im/','java/util/','java/awt/','java/lang/','java/time/','java/nio/','java/beans/','java/net/','java/io/','java/security/','java/text/','com/sun/xml/internal/ws/api/message/','com/sun/xml/internal/ws/api/','com/sun/xml/internal/ws/policy/','com/sun/xml/internal/ws/client/','com/sun/xml/internal/ws/model/','com/sun/xml/internal/ws/server/','com/sun/xml/internal/ws/util/','com/sun/xml/internal/ws/wsdl/','com/sun/xml/internal/ws/encoding/','com/sun/xml/internal/ws/resources/','com/sun/xml/internal/ws/message/','com/sun/xml/internal/ws/transport/','com/sun/xml/internal/ws/org/','com/sun/xml/internal/ws/addressing/','com/sun/xml/internal/ws/handler/','com/sun/xml/internal/messaging/saaj/soap/','com/sun/xml/internal/fastinfoset/stax/','com/sun/xml/internal/bind/v2/runtime/reflect/','com/sun/xml/internal/bind/v2/runtime/unmarshaller/','com/sun/xml/internal/bind/v2/runtime/','com/sun/xml/internal/bind/v2/model/','com/sun/xml/internal/ws/','com/sun/xml/internal/bind/','com/sun/xml/internal/messaging/','com/sun/xml/internal/fastinfoset/','com/sun/xml/internal/stream/','com/sun/org/apache/xpath/internal/res/','com/sun/org/apache/xpath/internal/axes/','com/sun/org/apache/xml/internal/security/keys/','com/sun/org/apache/xml/internal/security/utils/','com/sun/org/apache/xml/internal/security/encryption/','com/sun/org/apache/xml/internal/security/','com/sun/org/apache/xml/internal/dtm/','com/sun/org/apache/xml/internal/serializer/','com/sun/org/apache/xml/internal/utils/','com/sun/org/apache/xml/internal/res/','com/sun/org/apache/xerces/internal/impl/xs/traversers/','com/sun/org/apache/xerces/internal/impl/xs/opti/','com/sun/org/apache/xerces/internal/impl/xs/','com/sun/org/apache/xerces/internal/impl/dv/','com/sun/org/apache/xerces/internal/impl/xpath/','com/sun/org/apache/xerces/internal/impl/dtd/','com/sun/org/apache/xerces/internal/impl/','com/sun/org/apache/xerces/internal/dom/','com/sun/org/apache/xerces/internal/parsers/','com/sun/org/apache/xerces/internal/jaxp/','com/sun/org/apache/xerces/internal/util/','com/sun/org/apache/xalan/internal/xsltc/compiler/util/','com/sun/org/apache/xalan/internal/xsltc/compiler/','com/sun/org/apache/xalan/internal/xsltc/dom/','com/sun/org/apache/xalan/internal/xsltc/','com/sun/org/apache/xalan/internal/res/','com/sun/org/apache/bcel/internal/generic/','com/sun/org/apache/xerces/','com/sun/org/apache/xalan/','com/sun/org/apache/xml/','com/sun/org/apache/xpath/','com/sun/org/apache/','com/sun/media/sound/','com/sun/jndi/ldap/','com/sun/jmx/mbeanserver/','com/sun/java/util/jar/pack/','com/sun/java/swing/plaf/windows/resources/','com/sun/java/swing/plaf/gtk/resources/','com/sun/java/swing/plaf/windows/','com/sun/java/swing/plaf/gtk/','com/sun/imageio/plugins/jpeg/','com/sun/crypto/provider/','com/sun/corba/se/impl/logging/','com/sun/corba/se/impl/protocol/','com/sun/corba/se/impl/encoding/','com/sun/corba/se/impl/io/','com/sun/corba/se/impl/orbutil/','com/sun/corba/se/impl/orb/','com/sun/corba/se/impl/oa/','com/sun/corba/se/impl/transport/','com/sun/corba/se/impl/dynamicany/','com/sun/corba/se/impl/activation/','com/sun/corba/se/impl/presentation/','com/sun/corba/se/impl/naming/','com/sun/corba/se/impl/','com/sun/corba/se/spi/','com/sun/org/','com/sun/xml/','com/sun/corba/','com/sun/java/','com/sun/media/','com/sun/jndi/','com/sun/imageio/','com/sun/jmx/','com/sun/crypto/','com/sun/rowset/','com/sun/security/','com/sun/swing/','com/sun/','com/','sun/','javax/','java/','org/','jdk/','netscape/'";

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }

    public static void writeText(String content, String fileName) {
       
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("js/" + fileName)))
       {
           writer.write(content);
       } catch (IOException e) {
           throw new RuntimeException();
       }

    }

    public static void main(String[] args) throws Exception {
//        String s;
//        String[] a;
//        String url;
//        String f;
//        int i;
//
//        s = LIST_URL.replaceAll("'", "");
//        s = s.replaceAll("/", ".");
//        a = s.split(",");
//        for (i = 0; i < a.length; i++) {
//            url = MAIN_URL + a[i] + END_URL;
//            f = "rt.jar." + a[i] + END_URL;
//            String content = CherryConverter.getText(url);
//            CherryConverter.writeText(content, f);
//        }   
            String content = CherryConverter.getText("https://cjrtnc.leaningtech.com/2.1/loader.js");
            System.out.println(content);
    }

}
