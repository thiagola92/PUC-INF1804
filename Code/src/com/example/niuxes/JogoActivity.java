package com.example.niuxes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.game.Mapa;

public class JogoActivity extends Activity {
	
	static public Mapa tabuleiro;
	
	// quadrado selecionado
	public int quadrado1X;
	public int quadrado1Y;
	
	// quadrado ao qual esta se movimentando
	public int quadrado2X;
	public int quadrado2Y;
	
	// caso o jogador j� tenha selecionado uma pe�a
	public boolean pecaSelecionada = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo);
		
		SharedPreferences estadoDoJogo = this.getSharedPreferences("jogo", Context.MODE_PRIVATE);
		SharedPreferences pecas = this.getSharedPreferences("pecas", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = estadoDoJogo.edit();
		
		if ((estadoDoJogo.getBoolean("emJogo", false) == false) || (tabuleiro == null)) {
			
			editor.putBoolean("emJogo", true);
			editor.commit();
			
			if(estadoDoJogo.getBoolean("jogandoOnline", false) == false)	{
				
				tabuleiro = new Mapa(pecas.getInt("esquerda", 1),
										pecas.getInt("meio", 2),
										pecas.getInt("direita", 3));
				
				editor.putBoolean("jogandoOnline", false);
				editor.commit();
				
			} else {
				
				editor.putBoolean("jogandoOnline", true);
				editor.commit();
				
				// Caso o jogo seja online como deve ser tratado?

				tabuleiro = new Mapa(pecas.getInt("esquerda", 1),
										pecas.getInt("meio", 2),
										pecas.getInt("direita", 3),
										-1,
										-1,
										-1);
			}
		}
		
		carregarMapa();
		
	}
	
	@Override
	public void onBackPressed() {
		
		SharedPreferences estadoDoJogo = this.getSharedPreferences("jogo", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = estadoDoJogo.edit();

		editor.putBoolean("emJogo", false);
		editor.commit();
		
		super.onBackPressed();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_jogo, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.novoJogo) {
			onBackPressed();
    		return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public void carregarMapa() {

		ImageView x = (ImageView)findViewById(R.id.quadrado00);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][0]));
		x = (ImageView)findViewById(R.id.quadrado01);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][1]));
		x = (ImageView)findViewById(R.id.quadrado02);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][2]));
		x = (ImageView)findViewById(R.id.quadrado03);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][3]));
		x = (ImageView)findViewById(R.id.quadrado04);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][4]));
		x = (ImageView)findViewById(R.id.quadrado05);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][5]));
		x = (ImageView)findViewById(R.id.quadrado06);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[0][6]));
		
		x = (ImageView)findViewById(R.id.quadrado10);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][0]));
		x = (ImageView)findViewById(R.id.quadrado11);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][1]));
		x = (ImageView)findViewById(R.id.quadrado12);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][2]));
		x = (ImageView)findViewById(R.id.quadrado13);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][3]));
		x = (ImageView)findViewById(R.id.quadrado14);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][4]));
		x = (ImageView)findViewById(R.id.quadrado15);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][5]));
		x = (ImageView)findViewById(R.id.quadrado16);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[1][6]));
		
		x = (ImageView)findViewById(R.id.quadrado20);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][0]));
		x = (ImageView)findViewById(R.id.quadrado21);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][1]));
		x = (ImageView)findViewById(R.id.quadrado22);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][2]));
		x = (ImageView)findViewById(R.id.quadrado23);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][3]));
		x = (ImageView)findViewById(R.id.quadrado24);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][4]));
		x = (ImageView)findViewById(R.id.quadrado25);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][5]));
		x = (ImageView)findViewById(R.id.quadrado26);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[2][6]));
		
		x = (ImageView)findViewById(R.id.quadrado30);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][0]));
		x = (ImageView)findViewById(R.id.quadrado31);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][1]));
		x = (ImageView)findViewById(R.id.quadrado32);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][2]));
		x = (ImageView)findViewById(R.id.quadrado33);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][3]));
		x = (ImageView)findViewById(R.id.quadrado34);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][4]));
		x = (ImageView)findViewById(R.id.quadrado35);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][5]));
		x = (ImageView)findViewById(R.id.quadrado36);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[3][6]));
		
		x = (ImageView)findViewById(R.id.quadrado40);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][0]));
		x = (ImageView)findViewById(R.id.quadrado41);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][1]));
		x = (ImageView)findViewById(R.id.quadrado42);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][2]));
		x = (ImageView)findViewById(R.id.quadrado43);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][3]));
		x = (ImageView)findViewById(R.id.quadrado44);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][4]));
		x = (ImageView)findViewById(R.id.quadrado45);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][5]));
		x = (ImageView)findViewById(R.id.quadrado46);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[4][6]));
		
		x = (ImageView)findViewById(R.id.quadrado50);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][0]));
		x = (ImageView)findViewById(R.id.quadrado51);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][1]));
		x = (ImageView)findViewById(R.id.quadrado52);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][2]));
		x = (ImageView)findViewById(R.id.quadrado53);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][3]));
		x = (ImageView)findViewById(R.id.quadrado54);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][4]));
		x = (ImageView)findViewById(R.id.quadrado55);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][5]));
		x = (ImageView)findViewById(R.id.quadrado56);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[5][6]));
		
		x = (ImageView)findViewById(R.id.quadrado60);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][0]));
		x = (ImageView)findViewById(R.id.quadrado61);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][1]));
		x = (ImageView)findViewById(R.id.quadrado62);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][2]));
		x = (ImageView)findViewById(R.id.quadrado63);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][3]));
		x = (ImageView)findViewById(R.id.quadrado64);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][4]));
		x = (ImageView)findViewById(R.id.quadrado65);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][5]));
		x = (ImageView)findViewById(R.id.quadrado66);
		x.setImageResource(acharImagem(tabuleiro.mapaPos[6][6]));
	}

	/*
	 * Passe o valor no tabuleiro e vai devolver qual imagem deve ser desenhada l�.
	 */
	
	public int acharImagem(int x) {
		
		if(x>0) {
			if (x==1)
				return R.drawable.peca_soldado_branco;
			if (x==2)
				return R.drawable.peca_mago_branco;
			if (x==3)
				return R.drawable.peca_rei_branco;
			if (x==4)
				return R.drawable.peca_arqueiro_branco;
		} else if (x<0) {
			if (x==-1)
				return R.drawable.peca_soldado_preto;
			if (x==-2)
				return R.drawable.peca_mago_preto;
			if (x==-3)
				return R.drawable.peca_rei_preto;
			if (x==-4)
				return R.drawable.peca_arqueiro_preto;
		}
		
		return R.drawable.quadrado_vazio;
	}

	/*
	 * Passe a posi��o do mapa e vai retornar o id daquela posi��o.
	 */
	
	public int acharId(int x, int y) {
		
		if (x==0 && y==0)
			return R.id.quadrado00;
		if (x==0 && y==1)
			return R.id.quadrado01;
		if (x==0 && y==2)
			return R.id.quadrado02;
		if (x==0 && y==3)
			return R.id.quadrado03;
		if (x==0 && y==4)
			return R.id.quadrado04;
		if (x==0 && y==5)
			return R.id.quadrado05;
		if (x==0 && y==6)
			return R.id.quadrado06;
		
		if (x==1 && y==0)
			return R.id.quadrado10;
		if (x==1 && y==1)
			return R.id.quadrado11;
		if (x==1 && y==2)
			return R.id.quadrado12;
		if (x==1 && y==3)
			return R.id.quadrado13;
		if (x==1 && y==4)
			return R.id.quadrado14;
		if (x==1 && y==5)
			return R.id.quadrado15;
		if (x==1 && y==6)
			return R.id.quadrado16;
		
		if (x==2 && y==0)
			return R.id.quadrado20;
		if (x==2 && y==1)
			return R.id.quadrado21;
		if (x==2 && y==2)
			return R.id.quadrado22;
		if (x==2 && y==3)
			return R.id.quadrado23;
		if (x==2 && y==4)
			return R.id.quadrado24;
		if (x==2 && y==5)
			return R.id.quadrado25;
		if (x==2 && y==6)
			return R.id.quadrado26;
		
		if (x==3 && y==0)
			return R.id.quadrado30;
		if (x==3 && y==1)
			return R.id.quadrado31;
		if (x==3 && y==2)
			return R.id.quadrado32;
		if (x==3 && y==3)
			return R.id.quadrado33;
		if (x==3 && y==4)
			return R.id.quadrado34;
		if (x==3 && y==5)
			return R.id.quadrado35;
		if (x==3 && y==6)
			return R.id.quadrado36;
		
		if (x==4 && y==0)
			return R.id.quadrado40;
		if (x==4 && y==1)
			return R.id.quadrado41;
		if (x==4 && y==2)
			return R.id.quadrado42;
		if (x==4 && y==3)
			return R.id.quadrado43;
		if (x==4 && y==4)
			return R.id.quadrado44;
		if (x==4 && y==5)
			return R.id.quadrado45;
		if (x==4 && y==6)
			return R.id.quadrado46;
		
		if (x==5 && y==0)
			return R.id.quadrado50;
		if (x==5 && y==1)
			return R.id.quadrado51;
		if (x==5 && y==2)
			return R.id.quadrado52;
		if (x==5 && y==3)
			return R.id.quadrado53;
		if (x==5 && y==4)
			return R.id.quadrado54;
		if (x==5 && y==5)
			return R.id.quadrado55;
		if (x==5 && y==6)
			return R.id.quadrado56;
		
		if (x==6 && y==0)
			return R.id.quadrado60;
		if (x==6 && y==1)
			return R.id.quadrado61;
		if (x==6 && y==2)
			return R.id.quadrado62;
		if (x==6 && y==3)
			return R.id.quadrado63;
		if (x==6 && y==4)
			return R.id.quadrado64;
		if (x==6 && y==5)
			return R.id.quadrado65;
		if (x==6 && y==6)
			return R.id.quadrado66;
		
		return -1;
	}
	
	/*
	 * Descobri qual pe�a que esta fazendo o movimento.
	 * Chamar a fun��o com os movimentos da pe�a.
	 */
	
	public void descobrirMovimento() {
		
		if(tabuleiro.mapaPos[quadrado1X][quadrado1Y] == 1)
			soldadoMovimentos();
		else if (tabuleiro.mapaPos[quadrado1X][quadrado1Y] == 2)
			magoMovimentos();
		else if (tabuleiro.mapaPos[quadrado1X][quadrado1Y] == 3)
			reiMovimentos();
		else if (tabuleiro.mapaPos[quadrado1X][quadrado1Y] == 4)
			arqueiroMovimentos();
	}
	
	/*
	 * Essa parte talvez seja muito complicada.
	 * 
	 * Se os movimentos da pe�a j� tiverem aparecendo, desaparece.
	 * Se n�o, aparece.
	 * Aqui � onde voc� deve organizar os movimentos dos personagens.
	 * 
	 */
	
	public void soldadoMovimentos() {
		
		ImageView imagem;

		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}

		if ( (quadrado1X+2<=6) && (quadrado1X+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+2,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+2][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-2<=6) && (quadrado1X-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-2,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-2][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}

		if ( (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}

		if ( (quadrado1Y+2<=6) && (quadrado1Y+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y+2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y+2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1Y-2<=6) && (quadrado1Y-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y-2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y-2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
	}
	
	public void magoMovimentos() {
		
		ImageView imagem;
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-2<=6) && (quadrado1X-2>=0) && (quadrado1Y-2<=6) && (quadrado1Y-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-2,quadrado1Y-2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-2][quadrado1Y-2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-3<=6) && (quadrado1X-3>=0) && (quadrado1Y-3<=6) && (quadrado1Y-3>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-3,quadrado1Y-3));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-3][quadrado1Y-3]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-2<=6) && (quadrado1X-2>=0) && (quadrado1Y+2<=6) && (quadrado1Y+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-2,quadrado1Y+2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-2][quadrado1Y+2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-3<=6) && (quadrado1X-3>=0) && (quadrado1Y+3<=6) && (quadrado1Y+3>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-3,quadrado1Y+3));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-3][quadrado1Y+3]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+2<=6) && (quadrado1X+2>=0) && (quadrado1Y-2<=6) && (quadrado1Y-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+2,quadrado1Y-2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+2][quadrado1Y-2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+3<=6) && (quadrado1X+3>=0) && (quadrado1Y-3<=6) && (quadrado1Y-3>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+3,quadrado1Y-3));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+3][quadrado1Y-3]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+2<=6) && (quadrado1X+2>=0) && (quadrado1Y+2<=6) && (quadrado1Y+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+2,quadrado1Y+2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+2][quadrado1Y+2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+3<=6) && (quadrado1X+3>=0) && (quadrado1Y+3<=6) && (quadrado1Y+3>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+3,quadrado1Y+3));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+3][quadrado1Y+3]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
	}
	
	public void reiMovimentos() {
		
		ImageView imagem;
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
	}
	
	public void arqueiroMovimentos() {
		
		ImageView imagem;
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y-2<=6) && (quadrado1Y-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y-2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y-2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-2<=6) && (quadrado1X-2>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-2,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-2][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-1<=6) && (quadrado1X-1>=0) && (quadrado1Y+2<=6) && (quadrado1Y+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-1,quadrado1Y+2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-1][quadrado1Y+2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X-2<=6) && (quadrado1X-2>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X-2,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X-2][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y-2<=6) && (quadrado1Y-2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y-2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y-2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+2<=6) && (quadrado1X+2>=0) && (quadrado1Y-1<=6) && (quadrado1Y-1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+2,quadrado1Y-1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+2][quadrado1Y-1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+1<=6) && (quadrado1X+1>=0) && (quadrado1Y+2<=6) && (quadrado1Y+2>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+1,quadrado1Y+2));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+1][quadrado1Y+2]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
		if ( (quadrado1X+2<=6) && (quadrado1X+2>=0) && (quadrado1Y+1<=6) && (quadrado1Y+1>=0) ) {
			imagem = (ImageView)findViewById(acharId(quadrado1X+2,quadrado1Y+1));
			if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
				imagem.setImageResource(acharImagem(tabuleiro.mapaPos[quadrado1X+2][quadrado1Y+1]));
			} else {
				imagem.setImageResource(R.drawable.quadrado_ir);
			}
		}
		
	}
	
	/*
	 * Essa parte vai exigir um pouco de explica��o.
	 * Em pensei em duas maneiras de descobrir em qual lugar do tabuleiro o usu�rio esta tocando.
	 * 
	 * 1) Ele tocar em qualquer lugar da tela, chamar uma fun��o que vai varrer todos os quadrados do tabuleiro at� descobrir a pe�a tocada.
	 * 		Ex:
	 * public void descobrirPos (View view)
	 * 		if (view.getId() == R.id.quadrado00) {
	 * 			...
	 * 		} else if (view.getId() == R.id.quadrado01) {
	 * 			...
	 * 		} ...
	 * 
	 * Nesse caso teria 49 "if" seguidos, o que faria cada vez que voc� selecionar uma pe�a ter a chance de demorar dependendo de onde ela esteja.
	 * 
	 * 2) Cada quadrado chamar uma fun��o espefica pra ele, embora aumente o tamanho do codigo aqui, torna o jogo mais rapido para o usu�rio.
	 * 		Ex:
	 * public void selecionar00 (View view) {
	 * 	...
	 * }
	 * public void selecionar01 (View view) {
	 * 	...
	 * }
	 * ...
	 */

	public void selecionar00(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado00);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar01(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado01);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar02(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado02);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar03(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado03);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar04(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado04);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar05(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado05);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar06(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado06);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[0][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=0;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==0 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=0;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar10(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado10);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar11(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado11);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar12(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado12);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar13(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado13);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar14(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado14);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar15(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado15);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar16(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado16);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[1][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=1;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==1 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=1;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar20(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado20);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar21(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado21);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar22(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado22);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar23(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado23);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar24(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado24);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar25(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado25);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar26(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado26);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[2][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=2;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==2 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=2;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar30(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado30);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar31(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado31);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar32(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado32);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar33(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado33);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar34(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado34);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar35(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado30);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar36(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado30);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[3][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=3;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==3 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=3;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar40(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado40);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar41(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado41);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar42(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado42);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar43(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado43);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar44(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado44);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar45(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado45);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar46(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado46);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[4][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=4;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==4 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=4;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar50(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado50);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar51(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado51);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar52(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado52);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar53(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado53);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar54(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado54);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar55(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado55);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar56(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado56);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[5][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=5;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==5 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=5;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}

	public void selecionar60(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado60);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][0] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=0;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==0) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=0;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar61(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado61);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][1] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=1;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==1) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=1;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar62(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado62);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][2] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=2;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==2) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=2;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar63(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado63);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][3] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=3;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==3) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=3;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar64(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado64);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][4] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=4;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==4) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=4;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar65(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado65);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][5] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=5;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==5) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=5;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
	
	public void selecionar66(View view) {
		
		ImageView imagem = (ImageView)findViewById(R.id.quadrado66);
		
		if (pecaSelecionada==false) {
			
			if (tabuleiro.mapaPos[6][6] <= 0)
				return;
			
			pecaSelecionada=true;
			
			quadrado1X=6;
			quadrado1Y=6;
			
			descobrirMovimento();
		} else if (quadrado1X==6 && quadrado1Y==6) {
			pecaSelecionada=false;

			descobrirMovimento();
		} else if (imagem.getDrawable().getConstantState() == this.getResources().getDrawable(R.drawable.quadrado_ir).getConstantState()) {
			quadrado2X=6;
			quadrado2Y=6;

			descobrirMovimento();
			//Trocar as pe�as de lugar
			
			pecaSelecionada=false;
		}
		
	}
}
