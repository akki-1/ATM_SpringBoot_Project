<h1 align="center">Transfer</h1>
<br>
<br>
<form action="transprocess" method="post">
<b style="margin-left: 550px">${msg }</b>
<table style="margin: auto">
	<tr>
		<td><label for="Bank"> Select Your Bank</label></td>
		<td><select name="Bank" id="bank">
				<Option value="State Bank Of India">State Bank Of India</Option>
				<Option value="Central Bank Of India">Central Bank Of India</Option>
				<Option value="Maharashtra Bank Of India">Bank
					Of Maharashtra </Option>
				<Option value="Bank Of India">Bank Of India</Option>
				<Option value="Apna Bank Of India">Apna Bank of India</Option>
		</select></td>
	</tr>
	<tr>
		<td>Enter Account Number :</td>
		<td><input type="number" name="custaccount"></td>
	</tr>
	<tr>
		<td>Confirm Account Number</td>
		<td><input type="number" name="caccount"></td>
	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="number" name="tamount"></td>
	</tr>
	<tr>
		<td>PIN</td>
		<td><input type="number" name="pin"></td>
	</tr>

</table><br><br>
<button style="margin-left: 550px " id="bt" type="submit" class="btn btn-primary">Transfer</button><br>  

</form>