package net.thebyrdnest.aoc.utils;

public class Moon {
    int velocity;
    int posX;
    int posY;
    int posZ;

    int velX;
    int velY;
    int velZ;

    public Moon(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;

        velX = 0;
        velY = 0;
        velZ = 0;
    }

    public Moon(String line) {
        this(0,0,0);
        String[] parts = line.split("[=,>]");
        posX = Integer.parseInt(parts[1]);
        posY = Integer.parseInt(parts[3]);
        posZ = Integer.parseInt(parts[5]);
    }

    public int getPosX() { return posX; }

    public void setPosX(int value) { posX = value; }

    public int getPosY() { return posY; }

    public void setPosY(int value) { posY = value; }

    public int getPosZ() { return posZ; }

    public void setPosZ(int value) { posZ = value; }

    public int getVelX() { return velX; }
    public int getVelY() { return velY; }
    public int getVelZ() { return velZ; }

    public void applyGravity(Moon otherMoon) {
        if (posX < otherMoon.getPosX())
            velX++;
        else if (posX > otherMoon.getPosX())
            velX--;

        if (posY < otherMoon.getPosY())
            velY++;
        else if (posY > otherMoon.getPosY())
            velY--;

        if (posZ < otherMoon.getPosZ())
            velZ++;
        else if (posZ > otherMoon.getPosZ())
            velZ--;
    }

    public void applyVelocity() {
        posX += velX;
        posY += velY;
        posZ += velZ;
    }

    public int calcPotentialEnergy() {
        return Math.abs(posX) + Math.abs(posY) + Math.abs(posZ);
    }

    public int calcKineticEnergy() {
        return Math.abs(velX) + Math.abs(velY) + Math.abs(velZ);
    }

    public int calcTotalEnergy() {
        return calcPotentialEnergy() * calcKineticEnergy();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(" + posX + ", " + posY + ", " + posZ + ") -> (" + velX + ", " + velY + ", " + velZ + ")");
        return sb.toString();
    }
}
