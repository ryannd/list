'use client';

import UserDropdown from '@/components/layout/UserDropdown';
import { Button } from '@/components/ui/button';
import useFirebaseAuth from '@/features/auth/hooks/useAuth';
import { getAuth, onAuthStateChanged } from 'firebase/auth';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { useEffect, useState } from 'react';

export default function Header() {
    const pathname = usePathname();
    const user = useFirebaseAuth();
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        const auth = getAuth();
        const unsubscribe = onAuthStateChanged(auth, (user) => {
            if (user) {
                setIsLoggedIn(true);
            } else {
                setIsLoggedIn(false);
            }
        });

        return unsubscribe;
    }, [user]);

    if (pathname === '/auth') {
        return null;
    }

    return (
        <>
            <header className="sticky top-0 bg-black bg-opacity-60 backdrop-blur">
                <nav className="px-4 py-2.5 lg:px-6">
                    <div className="mx-auto flex max-w-screen-xl flex-wrap items-center justify-between">
                        <Link href="/">
                            <h1 className="self-center whitespace-nowrap text-xl font-semibold">
                                list.
                            </h1>
                        </Link>
                        <div className="flex items-center lg:order-2">
                            {!isLoggedIn && (
                                <Link href="/auth">
                                    <Button>Login</Button>
                                </Link>
                            )}
                            {isLoggedIn && <UserDropdown user={user} />}
                        </div>
                        <div
                            className="hidden w-full items-center justify-between lg:order-1 lg:flex lg:w-auto"
                            id="mobile-menu-2"
                        ></div>
                    </div>
                </nav>
            </header>
        </>
    );
}
