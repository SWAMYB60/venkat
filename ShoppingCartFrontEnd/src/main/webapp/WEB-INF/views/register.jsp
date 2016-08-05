<html>

<head>
<title>Registration Page</title>

</head>
<body id="wrap" style="background-color: WHITE;"> 
<h3><b><font size="6">SIGNUP</font></b></h3>
<form name="myform" method="POST" >

${message}

<table>
<tr>
        <td>FullName :</td>
           <td><input type="text" name="Fullname"  placeholder="Enter FullName" required/></td>
          
           
        
    </tr>
<tr>
        <td>Username :</td>
           <td><input type="text" name="username"  placeholder="Enter UserName" required/></td>
        
    </tr>
     <tr>
        <td>EmailId :</td>
           <td><input type="email" name="email"  placeholder="Enter Email" required /></td>
        
    </tr>

   
    <tr>
        <td>Password :</td>
        <td><input type="password" name="password"  placeholder="Enter Password"  required/></td>
    </tr>
    <tr>
    <td> Birthday:</td>
 <td> <input type="date" name="dob"  placeholder="Date Of Birth" required /></td>
 </tr>
     <tr>
    <td> Gender:</td>
<td><input type="radio" name="gender" value="male" checked required/> Male<br>
  <input type="radio" name="gender" value="female"/> Female<br></td>
  </tr>
 
    <tr>
    <td> Mobile.No:</td>
 <td> <input type="number" name="number" maxlength="10" placeholder="Enter Mobile No" required/></td>
 
    </tr>
    <tr>
    <td> Address:</td>
 <td> <input type="text" name="address"  placeholder="Enter Address" required /></td>
    </tr>
    
     <tr>
    <td> PinCode:</td>
 <td> <input type="text" name="pin"    placeholder="Enter Pincode" required/></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Register"></td>
       </tr>
      </table>
      
      
</form>
<br><br>
<br><font>Already have an account? </font> <a href="login">LOGIN</a>

<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>

