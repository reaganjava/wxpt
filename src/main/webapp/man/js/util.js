
//�Ƿ������ָ�ʽ���ַ���
function isDigit(str)
{
    return /^\d+$/.test(str);
}

//�Ƿ�������
function isInt(str)
{
    return /^[+-]?\d+$/.test(str);
}

//�Ƿ��Ǹ�����
function isFloat(str)
{
   return /^[+-]?(0\.\d+|0|[1-9]\d*(\.\d+)?)$/.test(str);
}

