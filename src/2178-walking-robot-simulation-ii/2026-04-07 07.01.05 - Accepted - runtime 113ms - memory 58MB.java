class Robot {
    int w;
    int h;
    int x = 0;
    int y = 0;
    String dir = "E";
    int full = 0;
    public Robot(int width, int height) {
        w = width;
        h = height;
        full =2*w + 2*(h-2);
    }
    
    public void step(int num) {
        num = num%full;
        dir = switch(dir){
            case "E" ->{
                if(x==0 && y==0){
                    yield "S";
                }
                yield dir;
            }
            case "S" ->{
                if(x==0 && y==h-1){
                    yield "W";
                }
                yield dir;
            }
            case "W" -> {
                if(x==w-1 && y == h-1){
                    yield "N";
                }
                yield dir;
            }

            default ->{
                if(y==0 && x == w-1){
                    yield "E";
                }
                yield dir;
            }

        };
        while(num > 0){
            switch(dir) {
                case "E":{
                    if(x+1 >= w){
                        dir = "N";
                    }else{
                        num--;
                        x++;
                    }
                    break;
                }

                case "N":{
                    if(y+1 >= h){
                        dir = "W";
                    }else{
                        num--;
                        y++;
                    }
                    break;
                }

                case "W":{
                    if(x-1 < 0){
                        dir = "S";
                    }else{
                        num--;
                        x--;
                    }
                    break;
                }

                case "S":{
                    if(y-1 <0){
                        dir = "E";
                    }else{
                        num--;
                        y--;
                    }
                    break;
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return switch(dir){
            case "E" -> "East";
            case "W" -> "West";
            case "N" -> "North";
            default -> "South";
        };
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */