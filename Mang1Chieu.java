package com.mycompany.mang1chieu;
import java.util.Scanner;

// Cài đặt lớp mảng 1 chiều
public class Mang1Chieu
{
    private int []a;
    private int n;
    
    // Nhập mảng 1 chiều
    public void Nhap()
    {
       Scanner sc = new Scanner (System.in);
       System.out.print("Nhap so phan tu: ");
       n = sc.nextInt();
       a = new int[n];
       
       for(int i = 0; i<n; i++)
       {
          System.out.print("a[" +i+ "] =" );
          a[i] = sc.nextInt();
       }
    }
    
    // Xuất mảng 1 chiều
    public void Xuat()
    {
       for(int i =0; i<n; i++)
       {
          System.out.print(a[i] + " ");
       }
       System.out.println();
    }
    
    // Tìm 1 phần tử trong mảng
    public int TimPhanTu(int x)
    {
       int i =0;
       while (i<n && a[i] != x)
           i++;
       if (i == n) 
           return -1;
       else 
           return i;
    }
    
    // Đếm theo số chắn
    public int DemSoChan()
    {
        int count = 0;
        for (int i =0; i<n; i++)
        {
           if(a[i] % 2 ==0 )
               count++;
        }
        return count;
    }
    
    // Xóa 1 phần tử
    public boolean XoaPhanTu(int x)
    {
        int index = TimPhanTu(x);
        if(index == -1)
            return false;
        
        for (int i = index; i<n-1; i++)
        {
            a[i] = a[i+1]; 
        }
        n--;
        return true;
    }
    
    // Tìm Max
    public int SoLonNhat()
    {
        if (n == 0) {
        System.out.println("Mang rong!");
        return 0;   
    }
        
        int Max = a[0];
        for (int i = 1; i<n; i++)
        {
           if (a[i] > Max)
              Max = a[i];
        }
        return Max;
    }
    
    // Tìm Min
    public int SoNhoNhat()
    {
        if (n == 0) {
        System.out.println("Mang rong!");
        return 0;  
    }
        
        int Min = a[0];
        for (int i = 1; i<n; i++)
        {
           if (a[i] < Min)
              Min = a[i];
        }
        return Min;
    }
    
    // Sắp xếp tăng (dùng Selection Sort)
    public void SapXepTang()
    {
      for(int i =0; i<n-1; i++)
      {
        for(int j =i+1; j<n; j++)
            if(a[i] > a[j])
            {
              int temp = a[i];
              a[i] = a[j];
              a[j] =temp;
            }
      }
    }
    
    public static void main(String[] args)
    {
       Mang1Chieu m = new Mang1Chieu();
       m.Nhap();
       m.Xuat();
       
       Scanner sc = new Scanner(System.in);
       System.out.print("Nhap so can tim: ");
       int x = sc.nextInt();
       int kq = m.TimPhanTu(x);
       if (kq != -1)
           System.out.println("Tim thay tai vi tri "+ kq);
       else 
           System.out.println("Khong tim thay phan tu trong mang");
       
       int dem = m.DemSoChan();
       System.out.println("So luong so chan: "+ dem);
       
       System.out.println("Nhap phan tu can xoa: ");
       int y = sc.nextInt();
       if(m.XoaPhanTu(y))
       {
           System.out.print("Mang sau khi xoa: ");
           m.Xuat();
       }
       else
           System.out.println("Khong tim thay phan tu de xoa!");
       
       int SLN = m.SoLonNhat();
       System.out.println("So lon nhat trong mang la: "+ SLN);
       
       int SNN = m.SoNhoNhat();
       System.out.println("So nho nhat trong mang la: "+ SNN);

       m.SapXepTang();
       System.out.print("Mang sau khi duoc sap xep tang: ");
       m.Xuat();
    }
    
    
}
