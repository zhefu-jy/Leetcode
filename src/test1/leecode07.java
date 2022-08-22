package test1;

/**
 * 1614. ���ŵ����Ƕ�����
 * ����ַ���������������֮һ������Գ�֮Ϊ ��Ч�����ַ�����valid parentheses string�����Լ�дΪ VPS����
 *
 * �ַ�����һ�����ַ��� ""��������һ����Ϊ "(" �� ")" �ĵ��ַ���
 * �ַ�������дΪ AB��A �� B �ַ������ӣ������� A �� B ���� ��Ч�����ַ��� ��
 * �ַ�������дΪ (A)������ A ��һ�� ��Ч�����ַ��� ��
 * ���Ƶأ����Զ����κ���Ч�����ַ��� S �� Ƕ����� depth(S)��
 *
 * depth("") = 0
 * depth(C) = 0������ C �ǵ����ַ����ַ������Ҹ��ַ����� "(" ���� ")"
 * depth(A + B) = max(depth(A), depth(B))������ A �� B ���� ��Ч�����ַ���
 * depth("(" + A + ")") = 1 + depth(A)������ A ��һ�� ��Ч�����ַ���
 * ���磺""��"()()"��"()(()())" ���� ��Ч�����ַ�����Ƕ����ȷֱ�Ϊ 0��1��2������ ")(" ��"(()" ������ ��Ч�����ַ��� ��
 */
public class leecode07 {
    public static void main(String[] args) {
        String s="(1+(2*3)+((8)/4))+1";
        int res=0;
        int count=0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='('){
                count++;
                res=Math.max(count,res);
            }
            if(s.charAt(i)==')'){
                count--;
            }
        }
        System.out.println(res);

    }
}