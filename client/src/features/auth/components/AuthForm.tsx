import {
    Card,
    CardContent,
    CardDescription,
    CardHeader,
    CardTitle,
} from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { FaGoogle } from 'react-icons/fa6';
import { signInWithGoogle } from '@/lib/firebase/auth';

export default function AuthForm() {
    const handleGoogleSignIn = async () => {
        await signInWithGoogle();
    };

    return (
        <Card className="w-full lg:w-[800px]">
            <CardHeader>
                <CardTitle>Login</CardTitle>
                <CardDescription>
                    Use one of the options below to login
                </CardDescription>
            </CardHeader>
            <CardContent>
                <Button className="w-full" onClick={handleGoogleSignIn}>
                    <FaGoogle /> Sign in with Google
                </Button>
            </CardContent>
        </Card>
    );
}
