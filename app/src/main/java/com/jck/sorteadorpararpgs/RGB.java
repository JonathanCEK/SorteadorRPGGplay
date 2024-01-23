package com.jck.sorteadorpararpgs;


public class RGB {

    private byte fase;
    private int velocidade;

    private int R;
    private int G;
    private int B;

    /*
    boolean flagRGB = true;

    Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                while(flagRGB){
                    componente.setBackground(r.getNextCor());
                    Thread.sleep(1);
                }
                componente.setBackground(r.getBranco());
            }
        });
        t.start();*/

    public RGB(){
        R = 255;
        B = 0;
        G = 0;
        fase = 0;
        velocidade = 1;
    }
    /*public Color getBranco(){
        return new Color.rgb(255, 255, 255);
    }

    public Color getNextCor(){
        this.setNextColor();
        return new Color.rgb(R, G, B);
    }*/

    public int[] getVetorNextCor(){
        int aux[] = {R, G, B};
        return aux;
    }


    private void setNextColor(){
        switch(fase){
            case 0:
                B += velocidade;
                if(B >= 255){
                    B = 255;
                    fase++;
                }
                break;
            case 1:
                R -= velocidade;
                if(R <= 0){
                    R = 0;
                    fase++;
                }
                break;
            case 2:
                G += velocidade;
                if(G >= 255){
                    G = 255;
                    fase++;
                }
                break;
            case 3:
                B -= velocidade;
                if(B <= 0){
                    B = 0;
                    fase++;
                }
                break;
            case 4:
                R += velocidade;
                if(R >= 255){
                    R = 255;
                    fase++;
                }
                break;

            case 5:
                G -= velocidade;
                if(G <= 0){
                    G = 0;
                    fase = 0;
                }
                break;
        }
    }
    public void setFase(byte fase){
        switch(fase){
            default:
                R = 255;
                B = 0;
                G = 0;
                fase = 0;
                break;
            case 1:
                R = 255;
                G = 0;
                B = 255;
                this.fase = 1;
                break;
            case 2:
                R = 0;
                G = 0;
                B = 255;
                this.fase = 2;
                break;
            case 3:
                R = 0;
                G = 255;
                B = 255;
                this.fase = 3;
                break;
            case 4:
                R = 0;
                G = 255;
                B = 0;
                this.fase = 4;
                break;
            case 5:
                R = 255;
                G = 255;
                B = 0;
                this.fase = 4;
                break;
        }
    }

    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }






}
