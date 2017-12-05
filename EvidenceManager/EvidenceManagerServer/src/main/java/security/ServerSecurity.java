/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import io.swagger.api.impl.Validator;
import io.swagger.model.Token;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MER
 */
public class ServerSecurity implements Validator {
    private SimpleDateFormat nowTime;
    
    private static final String N = "248461095643171896537156319663096694761967"
            + "72092091992014046668138059735795571392388905898726866170798401393"
            + "68754205054932739272208966839545681150328736361462412808758264493"
            + "75784406718614482866277471278232952692875637021639810922012007703"
            + "04347756087347865240299012686809534378709895339428206934549947168"
            + "02442936358915650521158852285095518568835546671413310837107970752"
            + "90208866949856083194526231971268930754888610643785268013217630380"
            + "74296596536901948507604833627112682765747583300826465700958423826"
            + "72131203811002524642495417522531049815414879677954183616165584109"
            + "7094646141617891256710672413422227705054443856658856741";
    
    private static final String D = "9655019602454680779509916032732063979165605"
            + "684267630724547872219237866637257212689055541925472128767869744765"
            + "246635068842754302297780747965253775565200389564632282292601286275"
            + "495068595281077018511515784065305103167499687276946935973087466224"
            + "485956891441192623760713704815039339631729163673782343562766615712"
            + "072328789146330940509920107228802861502774391293941782317066109057"
            + "137549905083418024773744960258288865209391457670818330365529286788"
            + "085254987875450165245203135152888321709240865866359518671543544732"
            + "276743748140352043786434931170062845846775272839498355626422650516"
            + "568837154021615965507235255616371723528844705";
    
    private BigInteger nBI;
    
    private BigInteger dBI;
    
    public ServerSecurity() {
        nBI = new BigInteger(this.N);
        dBI = new BigInteger(this.D);
    }
    
    public String decrypt(String message) {
        BigInteger m = new BigInteger(message);
        m = m.modPow(this.dBI, this.nBI);
        String s = this.numbersToMessage(m.toString());
        return s;
    }
    
    private String numbersToMessage(String message) {
        StringBuilder str = new StringBuilder();
        String m = message.substring(1);
        for (int i = 0; i < m.length(); i+=4) {
            int k = Integer.parseInt(m.substring(i, i+4));
            char c = (char) k;
            str.append(c);
        }
        return str.toString();
    }
    
    public String hash(String message) {
        return "";
    }
    
    public boolean callValidated(Token token) {
//        this.nowTime = new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
//        
//        String[] serverTimes = this.nowTime.format(new Date()).split(":");
//        String[] clientTimes = token.getTimeStamp().split(":");
//        
//        
//        if (this.nowTime.format(new Date()).compareTo(token.getTimeStamp()) > 0) {
//            return true;
//        }
//        
        return true;
    }
}
