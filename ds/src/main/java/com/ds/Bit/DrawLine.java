/**
 *
 */
package com.ds.Bit;

/**
 * Created by Abhishek Kumar
 * 12:56:01 PM Jul 29, 2012
 *
 * @Bangalore Cracking the Coding Interview 5.8
 * A monochrome screen is stored as a single array of bytes,allowing 8 consecutive pixels to be stored in one byte.
 * The screen has width w(divisible by 8),height( screen.length/(width/8)).
 * Implement a function drawHorizontalLine(byte[] screen,int width, int x1,int x2,int y)
 * which draws a horizontal line from(x1,y) to (x2,y).
 */
public class DrawLine {

  public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
    int start_offset = x1 % 8;
    int first_full_byte = x1 / 8;
    if (start_offset != 0) {
      first_full_byte++;
    }

    int end_offset = x2 % 8;
    int last_full_byte = x2 / 8;
    if (end_offset != 7) {
      last_full_byte--;
    }

    //Set full bytes
    for (int b = first_full_byte; b <= last_full_byte; b++) {
      screen[(width / 8) * y + b] = (byte) 0xFF;
    }

    //Create masks for residual start and end of the line
    byte start_mask = (byte) (0xFF >> start_offset);
    byte end_mask = (byte) (0xFF >> (end_offset + 1));

    //Set start and end of line
    if ((x1 / 8) == (x2 / 8)) {// x1 and x2 are in the same byte
      byte mask = (byte) (start_mask & end_mask);
      screen[(width / 8) * y + first_full_byte - 1] |= mask;
    } else {
      if (start_offset != 0) {
        int byte_number = (width / 8) * y + first_full_byte - 1;
        screen[byte_number] |= start_mask;
      }
      if (end_offset != 7) {
        int byte_number = (width / 8) * y + last_full_byte + 1;
        screen[byte_number] |= end_mask;
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
}
