package medium;

public class Solution468 {
    public String validIPAddress(String queryIP) {
        int length = queryIP.length();
        if (length < 7) {
            return "Neither";
        } else if (length < 15) {
            return checkIpv4(queryIP);
        } else if (length == 15) {
            if (queryIP.charAt(1) == ':') {
                return checkIpv6(queryIP);
            }
            return checkIpv4(queryIP);
        } else if (length <= 39) {
            return checkIpv6(queryIP);
        }
        return "Neither";
    }

    private String checkIpv4(String ip) {
        if (ip.charAt(ip.length() - 1) == '.') {
            return "Neither";
        }
        int count = 0;
        int sum = 0;
        for (int i = 0, l = ip.length(),p = -1; i < l; i++) {
            char c = ip.charAt(i);
            if (c == '.') {
                count++;
                int t = i - p;
                if (sum > 255 || t <= 1 || t > 4) {
                    return "Neither";
                }
                p = i;
                sum = 0;
            } else if (c == '0') {
                if (sum == 0 && i + 1 < l && ip.charAt(i + 1) != '.') {
                    return "Neither";
                }
            } else if (c > '0' && c <= '9') {
                sum = sum * 10 + c - '0';
            } else {
                return "Neither";
            }
        }
        if (sum > 255 || count != 3) {
            return "Neither";
        }
        return "IPv4";
    }

    private String checkIpv6(String ip) {
        if (ip.charAt(ip.length() - 1) == ':') {
            return "Neither";
        }
        int count = 0;
        int p = -1;
        for (int i = 0, l = ip.length(); i < l; i++) {
            char c = ip.charAt(i);
            if (c == ':') {
                count++;
                int t = i - p;
                if (t <= 1 || t > 5) {
                    return "Neither";
                }
                p = i;
            } else if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F')) {
                return "Neither";
            }
        }
        if (count != 7 || ip.length() - p > 5) {
            return "Neither";
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        Solution468 s = new Solution468();
        System.out.println(s.validIPAddress("192.168.1.0").equals("IPv4"));
        System.out.println(s.validIPAddress("192.81.1.").equals("Neither"));
        System.out.println(s.validIPAddress("192.168.01.1").equals("Neither"));
        System.out.println(s.validIPAddress("192.168.1.00").equals("Neither"));
        System.out.println(s.validIPAddress("192.161.1").equals("Neither"));
        System.out.println(s.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334").equals("IPv6"));
        System.out.println(s.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334").equals("IPv6"));
        System.out.println(s.validIPAddress("2001:0db8:85a3::8A2E:037j:7334").equals("Neither"));
        System.out.println(s.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334").equals("Neither"));
        System.out.println(s.validIPAddress("0.0.0.0").equals("IPv4"));
        System.out.println(s.validIPAddress("172.16.254.1").equals("IPv4"));
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334").equals("IPv6"));
        System.out.println(s.validIPAddress("0:0:0:0:0:0:0:0").equals("IPv6"));
        System.out.println(s.validIPAddress("256.256.256.256").equals("Neither"));
        System.out.println(s.validIPAddress("192.168.1.1").equals("IPv4"));
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:73341").equals("Neither"));
        System.out.println(s.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334").equals("Neither"));
    }
}
