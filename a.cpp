#include <bits/stdc++.h>
#include "user.hpp"
using namespace std;
//vrum vrum
#define fast_io ios_base::sync_with_stdio(0); cin.tie(0);
//constants
#define endl "\n"
#define exp 1e9
#define imax INT_MAX
#define imin INT_MIN
//functions
#define sqr(a) (a)*(a)
#define watch(x) cout << (#x) << " is " << (x) << endl
//utils
#define umap unordered_map
#define uset unordered_set
#define pb push_back
#define mk make_pair
#define fi first
#define sc second
//types
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int,int> pii;
bool prime(ll a) { if (a==1) return 0; for (int i=2;i*i<=a;++i) if (a%i==0) return 0; return 1; }

//usar cabecadlho
//usar lapide 
//usar indicador de tamanho de registro

class cb{
	private:		
		User user;			
		void ct(User u);
		User rd(int id);
		void up(User u);
		void dt(User u);
};

void cb::ct(User u){	
    ifstream fin ("db.txt");
	ofstream fout("db.txt");
	int n; fin >> n;
	const int k = (n * 10) + 1;
	//O(n) percorre sequencialmente ate chegar onde quer inserir
	for(int i = 0; i < k; ++i){
	//	watch(k);
		string tmp;
		getline(fin, tmp);
	}
	for(int i = 0; i < 10; ++i){

	}
	u.writeToFile(fout);
}

User cb::rd(int id){
	ifstream fin ("db.txt");
	for(int i = 0; i < id; ++i){
		string tmp;
		getline(fin, tmp);
	}
	User ans;
	return ans;
}

/*
 * formato do arquivo
 * int ultimo id armazenado
 * char lapide
 * int idConta 
 * string
 * 
 */
int main(){//fast_io;
	/*
	ofstream fout ("test.out");
    ifstream fin ("test.in");
	*/
	ofstream fout ("test.out");
	vector<string> email(1);
	email[0] = "teste@gmail";
	float tmp = 200.7;
	User u(1,"pedro", email, "pedrosa", "123", "11097763650", "brasilia", 100, tmp);
	u.writeToFile(fout);
	return (0);
}
