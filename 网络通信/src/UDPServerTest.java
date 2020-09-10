
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UDPServerTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DatagramSocket server = null;
        try {
            // 通过5050端口建立UDP服务端
            server = new DatagramSocket(5050);
            System.out.println(sdf.format(new Date()) + " UDP服务监听启动！");
            // 设置接收数据的缓冲区大小
            byte[] recvBuf = new byte[100];
            // 建立存放数据的数据报
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
            while (true) {
                // 建立服务端数据监听，此处阻塞
                server.receive(recvPacket);
                // 接收到数据后，取出数据
                String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
                System.out.println(sdf.format(new Date()) + " 从UDP客户端接收到消息：" + recvStr);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.close();
        }
    }
}