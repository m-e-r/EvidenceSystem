/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import static jdk.nashorn.internal.objects.NativeRegExp.test;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Guest Account
 */
public class ClientSecuriy {
  

/**
 *
 * @author MER
 */

    
    private static final String n = "248461095643171896537156319663096694761967"
            + "72092091992014046668138059735795571392388905898726866170798401393"
            + "68754205054932739272208966839545681150328736361462412808758264493"
            + "75784406718614482866277471278232952692875637021639810922012007703"
            + "04347756087347865240299012686809534378709895339428206934549947168"
            + "02442936358915650521158852285095518568835546671413310837107970752"
            + "90208866949856083194526231971268930754888610643785268013217630380"
            + "74296596536901948507604833627112682765747583300826465700958423826"
            + "72131203811002524642495417522531049815414879677954183616165584109"
            + "7094646141617891256710672413422227705054443856658856741";
    
    private static final String e = "767278482195590029138765730473564569387106"
            + "21036804682525512918241133970081309125995747093301543324189170035"
            + "34513762712322505122420702746555598422982357809017148108217076604"
            + "59819265281614132980137684723796563472714264909438622350757336583"
            + "86117842463395819543822594287413822732375245097811203275996826110"
            + "56294251431799337805588896565055270996986687757573197148023646190"
            + "39447769436759832823381970433688039495719339236740875051607386132"
            + "75535677577667715377445252039747924531930948513504330924505535528"
            + "72165759629160744721474377168318662472572177028484481128552176780"
            + "258165133027801789915866451832227987862112469984557693";
    
    private static final String d = "9655019602454680779509916032732063979165605"
            + "684267630724547872219237866637257212689055541925472128767869744765"
            + "246635068842754302297780747965253775565200389564632282292601286275"
            + "495068595281077018511515784065305103167499687276946935973087466224"
            + "485956891441192623760713704815039339631729163673782343562766615712"
            + "072328789146330940509920107228802861502774391293941782317066109057"
            + "137549905083418024773744960258288865209391457670818330365529286788"
            + "085254987875450165245203135152888321709240865866359518671543544732"
            + "276743748140352043786434931170062845846775272839498355626422650516"
            + "568837154021615965507235255616371723528844705";
    

    
    public String encrypt() {
        BigInteger nn = new BigInteger(this.n);
        BigInteger ee = new BigInteger(this.e);
        BigInteger dd = new BigInteger(this.d);
        String m = "asdfghjklqwertyuiopvasqwercdfhdjslketugg";
        StringBuilder str = new StringBuilder();
        String s;
        str.append('1');
        for (char c : m.toCharArray()) {
            int i = c;
            s = "" + i;
            System.out.println(i);
            while (s.length() < 4) {
                s = "0" + s;
            }
            
            str.append(s);
        }
        BigInteger w = new BigInteger(str.toString());
        w = w.modPow(ee, nn);
        return w.toString();
    }
   /* 
    public void generate() {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(1024, rnd);
        BigInteger q = BigInteger.probablePrime(1024, rnd);
        BigInteger nn = p.multiply(q);
        BigInteger l = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger ee = null;
        do {
            ee = new BigInteger(l.bitLength(), rnd);
        } while ((ee.compareTo(BigInteger.ONE) <= 0 || ee.compareTo(l) >= 0 || !ee.gcd(l).equals(BigInteger.ONE)));
        BigInteger z = ee.modInverse(l);
        System.out.println(z);
        System.out.println(e);
        System.out.println(n);
    }
    */
    
   
    
}
