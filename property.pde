int colour = 1;
Drawing drawing = new Drawing();
Drawing backup = (Drawing) drawing.clone();

PImage save;
PImage undo;
PImage clean;

void setup() {
  size(1200, 600);
  save = loadImage("save.png");
  undo = loadImage("undo.png");
  clean = loadImage("clean.png");
}

void draw() {
  background(255);
  strokeWeight(2);
  
  Coordinate lastCoordinate = null;  
  ArrayList<Coordinate> coordinates = drawing.getCoordinates();
  ArrayList<Integer> disconnections = drawing.getDisconnections();
  
  for(int i = 0; i < coordinates.size(); i++) {
    if(lastCoordinate != null && !disconnections.contains(i - 1)) {
      switch(coordinates.get(i).colour) {
        case 1:
          fill(60, 196, 101);
          stroke(60, 196, 101);
          break;
        case 2:
          fill(30, 179, 253);
          stroke(30, 179, 253);
          break;
        case 3:
          fill(255, 168, 0);
          stroke(255, 168, 0);
          break;
        case 4:
          fill(251, 3, 53);
          stroke(251, 3, 53);
          break;
        case 5:
          fill(0, 0, 0);
          stroke(0, 0, 0);
          break;
      }
      line(coordinates.get(i).x, coordinates.get(i).y, lastCoordinate.x, lastCoordinate.y);
    }
    lastCoordinate = coordinates.get(i);
  }
  
  strokeWeight(5);
  
  fill(60, 196, 101);
  if(colour != 1) {
    stroke(255, 255, 255);
  } else {
    stroke(60, 196, 101);
  }
  square(20, 10, 20);
  
  fill(30, 179, 253);
  if(colour != 2) {
    stroke(255, 255, 255);
  } else {
    stroke(30, 179, 253);
  }
  square(20, 40, 20);
  
  fill(255, 168, 0);
  if(colour != 3) {
    stroke(255, 255, 255);
  } else {
    stroke(255, 168, 0);
  }
  square(20, 70, 20);
  
  fill(251, 3, 53);
  if(colour != 4) {
    stroke(255, 255, 255);
  } else {
    stroke(251, 3, 53);
  }
  square(20, 100, 20);
  
  fill(0, 0, 0);
  if(colour != 5) {
    stroke(255, 255, 255);
  } else {
    stroke(0, 0, 0);
  }
  square(20, 130, 20);
  
  image(save, width - 120, 20, 25, 25);
  image(undo, width - 85, 20, 25, 25);
  image(clean, width - 50, 20, 25, 25);
}

void mousePressed() {
  if(mouseX >= 20 && mouseX <= 40
    && mouseY >= 10 && mouseY <= 150) {
    if(mouseY >= 10 && mouseY <= 30) {
      colour = 1;
    }
    if(mouseY >= 40 && mouseY <= 60) {
      colour = 2;
    }
    if(mouseY >= 70 && mouseY <= 90) {
      colour = 3;
    }
    if(mouseY >= 100 && mouseY <= 120) {
      colour = 4;
    }
    if(mouseY >= 130 && mouseY <= 150) {
      colour = 5;
    }
  } else if(mouseX >= width - 120 && mouseX <= width - 25
            && mouseY >= 20 && mouseY <= 45) {
    if(mouseX >= width - 120 && mouseX <= width - 95) {
      drawing.save();
      backup = (Drawing) drawing.clone();
    }
    if(mouseX >= width - 85 && mouseX <= width - 60) {
      drawing = (Drawing) backup.clone();
      backup = (Drawing) drawing.clone();
    }
    if(mouseX >= width - 50 && mouseX <= width - 25) {
      drawing.clean();
      backup = (Drawing) drawing.clone();
    }
  }
}

void mouseDragged() {
  Coordinate coord = new Coordinate(
    mouseX,
    mouseY,
    colour
  );
  drawing.getCoordinates().add(coord);
}

void mouseReleased() {
  drawing.getDisconnections().add(drawing.getCoordinates().size() - 1);
}
